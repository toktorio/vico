/*
 * Copyright 2024 by Patryk Goworowski and Patrick Michalik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.patrykandpatrick.vico.sample.showcase.charts

import android.graphics.RectF
import android.graphics.Typeface
import android.util.Log
import android.widget.Toast
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.compose.chart.CartesianChartHost
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineSpec
import com.patrykandpatrick.vico.compose.chart.rememberCartesianChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberVicoScrollState
import com.patrykandpatrick.vico.compose.chart.zoom.rememberVicoZoomState
import com.patrykandpatrick.vico.compose.component.rememberLayeredComponent
import com.patrykandpatrick.vico.compose.component.rememberShapeComponent
import com.patrykandpatrick.vico.compose.component.rememberTextComponent
import com.patrykandpatrick.vico.compose.component.shape.markerCorneredShape
import com.patrykandpatrick.vico.compose.component.shape.shader.color
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.core.chart.dimensions.HorizontalDimensions
import com.patrykandpatrick.vico.core.chart.insets.Insets
import com.patrykandpatrick.vico.core.chart.layout.HorizontalLayout
import com.patrykandpatrick.vico.core.chart.values.ChartValues
import com.patrykandpatrick.vico.core.component.marker.MarkerComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.component.shape.cornered.Corner
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.context.DrawContext
import com.patrykandpatrick.vico.core.context.MeasureContext
import com.patrykandpatrick.vico.core.extension.copyColor
import com.patrykandpatrick.vico.core.extension.half
import com.patrykandpatrick.vico.core.marker.Marker
import com.patrykandpatrick.vico.core.marker.MarkerVisibilityChangeListener
import com.patrykandpatrick.vico.core.model.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.model.lineSeries
import com.patrykandpatrick.vico.core.zoom.Zoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
internal fun Chart10(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val dollarPoints = listOf(
        100_000.12, 110_000.23, 120_000.43, 130_000.44, 105_000.22, 102_233.23, 140_232.45,
        145_256.23, 100_232.11, 130_123.23, 150_232.23, 160_232.67, 180_666.99, 200_050.50,
    )
    val modelProducer = remember { CartesianChartModelProducer.build() }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            modelProducer.tryRunTransaction {
                lineSeries { series(dollarPoints) }
            }
        }
    }
    CartesianChartHost(
        chart = rememberCartesianChart(
            rememberLineCartesianLayer(
                listOf(
                    rememberLineSpec(
                        shader = DynamicShaders.color(Color(0xff4CAF50)),
                        cap = StrokeCap.Butt,
                    ),
                ),
            ),
            startAxis = null,
            bottomAxis = null,
            persistentMarkers = null,
        ),
        modelProducer = modelProducer,
        modifier = modifier,
        marker = rememberMarker(),
        markerVisibilityChangeListener = object : MarkerVisibilityChangeListener {
            override fun onMarkerShown(marker: Marker, markerEntryModels: List<Marker.EntryModel>) {
                Log.d("Chart10", "onMarkerShown")
            }

            override fun onMarkerMoved(marker: Marker, markerEntryModels: List<Marker.EntryModel>) {
                Log.d("Chart10", "onMarkerMoved: markerEntryModels: $markerEntryModels")
                val dollarPoint = dollarPoints.getOrNull(markerEntryModels.firstOrNull()?.index ?: -1)
                Toast.makeText(context, dollarPoint?.toString(), Toast.LENGTH_SHORT).show()
                super.onMarkerMoved(marker, markerEntryModels)
            }

            override fun onMarkerHidden(marker: Marker) {
                Log.d("Chart10", "onMarkerHidden")
            }
        },
        scrollState = rememberVicoScrollState(scrollEnabled = false),
        zoomState = rememberVicoZoomState(
            zoomEnabled = false,
            initialZoom = remember { Zoom.Content },
            maxZoom = remember { Zoom.Content },
        ),
        horizontalLayout = HorizontalLayout.FullWidth(scalableEndPaddingDp = 16f),
    )
}

@Composable
private fun rememberMarker(): Marker {
    val labelBackgroundShape = Shapes.markerCorneredShape(Corner.FullyRounded)
    val labelBackground = rememberShapeComponent(labelBackgroundShape, MaterialTheme.colorScheme.surface)
    val label = rememberTextComponent(
        color = MaterialTheme.colorScheme.onSurface,
        background = labelBackground,
        padding = dimensionsOf(8.dp, 4.dp),
        typeface = Typeface.MONOSPACE,
    )
    val indicatorFrontComponent = rememberShapeComponent(Shapes.pillShape, MaterialTheme.colorScheme.surface)
    val indicatorCenterComponent = rememberShapeComponent(Shapes.pillShape)
    val indicatorRearComponent = rememberShapeComponent(Shapes.pillShape)
    val indicator = rememberLayeredComponent(
        rear = indicatorRearComponent,
        front = rememberLayeredComponent(
            rear = indicatorCenterComponent,
            front = indicatorFrontComponent,
            padding = dimensionsOf(5.dp),
        ),
        padding = dimensionsOf(10.dp),
    )
    return remember(label, indicator) {
        object : MarkerComponent(label, LabelPosition.Top, indicator) {
            init {
                indicatorSizeDp = 36f
                onApplyEntryColor = { entryColor ->
                    indicatorRearComponent.color = entryColor.copyColor(alpha = .15f)
                    with(indicatorCenterComponent) {
                        color = entryColor
                        setShadow(radius = 12f, color = entryColor)
                    }
                }
            }

            override fun draw(
                context: DrawContext,
                bounds: RectF,
                markedEntries: List<Marker.EntryModel>,
                chartValues: ChartValues,
            ) {
                with(context) {
                    val halfIndicatorSize = indicatorSizeDp.half.pixels
                    markedEntries.forEachIndexed { _, model ->
                        onApplyEntryColor?.invoke(model.color)
                        indicator.draw(
                            context,
                            model.location.x - halfIndicatorSize,
                            model.location.y - halfIndicatorSize,
                            model.location.x + halfIndicatorSize,
                            model.location.y + halfIndicatorSize,
                        )
                    }
                }
            }

            override fun getInsets(
                context: MeasureContext,
                outInsets: Insets,
                horizontalDimensions: HorizontalDimensions,
            ) {
                with(context) {
                    outInsets.top = (CLIPPING_FREE_SHADOW_RADIUS_MULTIPLIER * LABEL_BACKGROUND_SHADOW_RADIUS_DP -
                        LABEL_BACKGROUND_SHADOW_DY_DP).pixels
                    if (labelPosition == LabelPosition.AroundPoint) return
                    outInsets.top += label.getHeight(context) + labelBackgroundShape.tickSizeDp.pixels
                }
            }
        }
    }
}

private const val LABEL_BACKGROUND_SHADOW_RADIUS_DP = 4f
private const val LABEL_BACKGROUND_SHADOW_DY_DP = 2f
private const val CLIPPING_FREE_SHADOW_RADIUS_MULTIPLIER = 1.4f

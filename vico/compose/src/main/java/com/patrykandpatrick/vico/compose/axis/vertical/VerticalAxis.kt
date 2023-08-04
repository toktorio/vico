/*
 * Copyright 2023 by Patryk Goworowski and Patrick Michalik.
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

package com.patrykandpatrick.vico.compose.axis.vertical

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import com.patrykandpatrick.vico.compose.axis.axisGuidelineComponent
import com.patrykandpatrick.vico.compose.axis.axisLabelComponent
import com.patrykandpatrick.vico.compose.axis.axisLineComponent
import com.patrykandpatrick.vico.compose.axis.axisTickComponent
import com.patrykandpatrick.vico.compose.style.currentChartStyle
import com.patrykandpatrick.vico.core.axis.Axis
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.axis.formatter.AxisValueFormatter
import com.patrykandpatrick.vico.core.axis.formatter.DecimalFormatAxisValueFormatter
import com.patrykandpatrick.vico.core.axis.vertical.VerticalAxis
import com.patrykandpatrick.vico.core.axis.vertical.createVerticalAxis
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.text.TextComponent

/**
 * Creates a start axis (i.e., a [VerticalAxis] with [AxisPosition.Vertical.Start]).
 *
 * @param label the [TextComponent] to use for the labels.
 * @param axis the [LineComponent] to use for the axis line.
 * @param tick the [LineComponent] to use for the ticks.
 * @param tickLength the length of the ticks.
 * @param guideline the [LineComponent] to use for the guidelines.
 * @param valueFormatter formats the labels.
 * @param sizeConstraint defines how the [VerticalAxis] is to size itself.
 * @param horizontalLabelPosition the horizontal position of the labels.
 * @param verticalLabelPosition the vertical position of the labels.
 * @param itemPlacer determines for what _y_ values the [VerticalAxis] is to display labels, ticks, and guidelines.
 * @param labelRotationDegrees the rotation of the axis labels (in degrees).
 * @param titleComponent an optional [TextComponent] to use as the axis title.
 * @param title the axis title.
 */
@Composable
public fun startAxis(
    label: TextComponent? = axisLabelComponent(),
    axis: LineComponent? = axisLineComponent(),
    tick: LineComponent? = axisTickComponent(),
    tickLength: Dp = currentChartStyle.axis.axisTickLength,
    guideline: LineComponent? = axisGuidelineComponent(),
    valueFormatter: AxisValueFormatter<AxisPosition.Vertical.Start> = DecimalFormatAxisValueFormatter(),
    sizeConstraint: Axis.SizeConstraint = Axis.SizeConstraint.Auto(),
    horizontalLabelPosition: VerticalAxis.HorizontalLabelPosition = VerticalAxis.HorizontalLabelPosition.Outside,
    verticalLabelPosition: VerticalAxis.VerticalLabelPosition = VerticalAxis.VerticalLabelPosition.Center,
    itemPlacer: AxisItemPlacer.Vertical = remember { AxisItemPlacer.Vertical.default() },
    labelRotationDegrees: Float = currentChartStyle.axis.axisLabelRotationDegrees,
    titleComponent: TextComponent? = null,
    title: CharSequence? = null,
): VerticalAxis<AxisPosition.Vertical.Start> = createVerticalAxis {
    this.label = label
    this.axis = axis
    this.tick = tick
    this.guideline = guideline
    this.valueFormatter = valueFormatter
    tickLengthDp = tickLength.value
    this.sizeConstraint = sizeConstraint
    this.horizontalLabelPosition = horizontalLabelPosition
    this.verticalLabelPosition = verticalLabelPosition
    this.itemPlacer = itemPlacer
    this.labelRotationDegrees = labelRotationDegrees
    this.titleComponent = titleComponent
    this.title = title
}

/**
 * Creates an end axis (i.e., a [VerticalAxis] with [AxisPosition.Vertical.End]).
 *
 * @param label the [TextComponent] to use for the labels.
 * @param axis the [LineComponent] to use for the axis line.
 * @param tick the [LineComponent] to use for the ticks.
 * @param tickLength the length of the ticks.
 * @param guideline the [LineComponent] to use for the guidelines.
 * @param valueFormatter formats the labels.
 * @param sizeConstraint defines how the [VerticalAxis] is to size itself.
 * @param horizontalLabelPosition the horizontal position of the labels.
 * @param verticalLabelPosition the vertical position of the labels.
 * @param itemPlacer determines for what _y_ values the [VerticalAxis] is to display labels, ticks, and guidelines.
 * @param labelRotationDegrees the rotation of the axis labels (in degrees).
 * @param titleComponent an optional [TextComponent] to use as the axis title.
 * @param title the axis title.
 */
@Composable
public fun endAxis(
    label: TextComponent? = axisLabelComponent(),
    axis: LineComponent? = axisLineComponent(),
    tick: LineComponent? = axisTickComponent(),
    tickLength: Dp = currentChartStyle.axis.axisTickLength,
    guideline: LineComponent? = axisGuidelineComponent(),
    valueFormatter: AxisValueFormatter<AxisPosition.Vertical.End> = DecimalFormatAxisValueFormatter(),
    sizeConstraint: Axis.SizeConstraint = Axis.SizeConstraint.Auto(),
    horizontalLabelPosition: VerticalAxis.HorizontalLabelPosition = VerticalAxis.HorizontalLabelPosition.Outside,
    verticalLabelPosition: VerticalAxis.VerticalLabelPosition = VerticalAxis.VerticalLabelPosition.Center,
    itemPlacer: AxisItemPlacer.Vertical = remember { AxisItemPlacer.Vertical.default() },
    labelRotationDegrees: Float = currentChartStyle.axis.axisLabelRotationDegrees,
    titleComponent: TextComponent? = null,
    title: CharSequence? = null,
): VerticalAxis<AxisPosition.Vertical.End> = createVerticalAxis {
    this.label = label
    this.axis = axis
    this.tick = tick
    this.guideline = guideline
    this.valueFormatter = valueFormatter
    this.tickLengthDp = tickLength.value
    this.sizeConstraint = sizeConstraint
    this.horizontalLabelPosition = horizontalLabelPosition
    this.verticalLabelPosition = verticalLabelPosition
    this.itemPlacer = itemPlacer
    this.labelRotationDegrees = labelRotationDegrees
    this.titleComponent = titleComponent
    this.title = title
}

/**
 * Creates a start axis (i.e., a [VerticalAxis] with [AxisPosition.Vertical.Start]).
 *
 * @param label the [TextComponent] to use for the labels.
 * @param axis the [LineComponent] to use for the axis line.
 * @param tick the [LineComponent] to use for the ticks.
 * @param tickLength the length of the ticks.
 * @param guideline the [LineComponent] to use for the guidelines.
 * @param valueFormatter formats the labels.
 * @param sizeConstraint defines how the [VerticalAxis] is to size itself.
 * @param horizontalLabelPosition the horizontal position of the labels.
 * @param verticalLabelPosition the vertical position of the labels.
 * @param maxLabelCount the maximum label count.
 * @param labelRotationDegrees the rotation of the axis labels (in degrees).
 * @param titleComponent an optional [TextComponent] to use as the axis title.
 * @param title the axis title.
 */
@Composable
@Deprecated(
    """
        `maxLabelCount` is being replaced by `AxisItemPlacer.Vertical`. Create a base implementation with the desired
        maximum item count via `AxisItemPlacer.Vertical.default`, and use the `itemPlacer` parameter of the other
        `startAxis` overload to apply it to the `VerticalAxis` being created.
    """,
    ReplaceWith(
        """
            startAxis(
                label = label,
                axis = axis,
                tick = tick,
                tickLength = tickLength,
                guideline = guideline,
                valueFormatter = valueFormatter,
                sizeConstraint = sizeConstraint,
                horizontalLabelPosition = horizontalLabelPosition,
                verticalLabelPosition = verticalLabelPosition,
                itemPlacer = remember { AxisItemPlacer.Vertical.default(maxLabelCount) },
                labelRotationDegrees = labelRotationDegrees,
                titleComponent = titleComponent,
                title = title,
            )
        """,
        "com.patrykandpatrick.vico.core.axis.AxisItemPlacer",
        "androidx.compose.runtime.remember",
    ),
)
public fun startAxis(
    label: TextComponent? = axisLabelComponent(),
    axis: LineComponent? = axisLineComponent(),
    tick: LineComponent? = axisTickComponent(),
    tickLength: Dp = currentChartStyle.axis.axisTickLength,
    guideline: LineComponent? = axisGuidelineComponent(),
    valueFormatter: AxisValueFormatter<AxisPosition.Vertical.Start> = DecimalFormatAxisValueFormatter(),
    sizeConstraint: Axis.SizeConstraint = Axis.SizeConstraint.Auto(),
    horizontalLabelPosition: VerticalAxis.HorizontalLabelPosition = VerticalAxis.HorizontalLabelPosition.Outside,
    verticalLabelPosition: VerticalAxis.VerticalLabelPosition = VerticalAxis.VerticalLabelPosition.Center,
    maxLabelCount: Int,
    labelRotationDegrees: Float = currentChartStyle.axis.axisLabelRotationDegrees,
    titleComponent: TextComponent? = null,
    title: CharSequence? = null,
): VerticalAxis<AxisPosition.Vertical.Start> = startAxis(
    label,
    axis,
    tick,
    tickLength,
    guideline,
    valueFormatter,
    sizeConstraint,
    horizontalLabelPosition,
    verticalLabelPosition,
    remember { AxisItemPlacer.Vertical.default(maxLabelCount) },
    labelRotationDegrees,
    titleComponent,
    title,
)

/**
 * Creates an end axis (i.e., a [VerticalAxis] with [AxisPosition.Vertical.End]).
 *
 * @param label the [TextComponent] to use for the labels.
 * @param axis the [LineComponent] to use for the axis line.
 * @param tick the [LineComponent] to use for the ticks.
 * @param tickLength the length of the ticks.
 * @param guideline the [LineComponent] to use for the guidelines.
 * @param valueFormatter formats the labels.
 * @param sizeConstraint defines how the [VerticalAxis] is to size itself.
 * @param horizontalLabelPosition the horizontal position of the labels.
 * @param verticalLabelPosition the vertical position of the labels.
 * @param maxLabelCount the maximum label count.
 * @param labelRotationDegrees the rotation of the axis labels (in degrees).
 * @param titleComponent an optional [TextComponent] to use as the axis title.
 * @param title the axis title.
 */
@Composable
@Deprecated(
    """
        `maxLabelCount` is being replaced by `AxisItemPlacer.Vertical`. Create a base implementation with the desired
        maximum item count via `AxisItemPlacer.Vertical.default`, and use the `itemPlacer` parameter of the other
        `endAxis` overload to apply it to the `VerticalAxis` being created.
    """,
    ReplaceWith(
        """
            endAxis(
                label = label,
                axis = axis,
                tick = tick,
                tickLength = tickLength,
                guideline = guideline,
                valueFormatter = valueFormatter,
                sizeConstraint = sizeConstraint,
                horizontalLabelPosition = horizontalLabelPosition,
                verticalLabelPosition = verticalLabelPosition,
                itemPlacer = remember { AxisItemPlacer.Vertical.default(maxLabelCount) },
                labelRotationDegrees = labelRotationDegrees,
                titleComponent = titleComponent,
                title = title,
            )
        """,
        "com.patrykandpatrick.vico.core.axis.AxisItemPlacer",
        "androidx.compose.runtime.remember",
    ),
)
public fun endAxis(
    label: TextComponent? = axisLabelComponent(),
    axis: LineComponent? = axisLineComponent(),
    tick: LineComponent? = axisTickComponent(),
    tickLength: Dp = currentChartStyle.axis.axisTickLength,
    guideline: LineComponent? = axisGuidelineComponent(),
    valueFormatter: AxisValueFormatter<AxisPosition.Vertical.End> = DecimalFormatAxisValueFormatter(),
    sizeConstraint: Axis.SizeConstraint = Axis.SizeConstraint.Auto(),
    horizontalLabelPosition: VerticalAxis.HorizontalLabelPosition = VerticalAxis.HorizontalLabelPosition.Outside,
    verticalLabelPosition: VerticalAxis.VerticalLabelPosition = VerticalAxis.VerticalLabelPosition.Center,
    maxLabelCount: Int,
    labelRotationDegrees: Float = currentChartStyle.axis.axisLabelRotationDegrees,
    titleComponent: TextComponent? = null,
    title: CharSequence? = null,
): VerticalAxis<AxisPosition.Vertical.End> = endAxis(
    label,
    axis,
    tick,
    tickLength,
    guideline,
    valueFormatter,
    sizeConstraint,
    horizontalLabelPosition,
    verticalLabelPosition,
    remember { AxisItemPlacer.Vertical.default(maxLabelCount) },
    labelRotationDegrees,
    titleComponent,
    title,
)

package ru.tech.imageresizershrinker.coreui.theme

import androidx.compose.runtime.Composable
import com.t8rin.dynamic.theme.DynamicTheme
import com.t8rin.dynamic.theme.rememberAppColorTuple
import com.t8rin.dynamic.theme.rememberDynamicThemeState
import ru.tech.imageresizershrinker.coreui.widget.utils.LocalSettingsState

@Composable
fun ImageToolboxTheme(
    dynamicColor: Boolean = LocalSettingsState.current.isDynamicColors,
    amoledMode: Boolean = LocalSettingsState.current.isAmoledMode,
    content: @Composable () -> Unit
) {
    val settingsState = LocalSettingsState.current
    DynamicTheme(
        typography = Typography(settingsState.font),
        state = rememberDynamicThemeState(
            rememberAppColorTuple(
                defaultColorTuple = settingsState.appColorTuple,
                dynamicColor = dynamicColor,
                darkTheme = settingsState.isNightMode
            )
        ),
        defaultColorTuple = settingsState.appColorTuple,
        dynamicColor = dynamicColor,
        amoledMode = amoledMode,
        isDarkTheme = settingsState.isNightMode,
        contrastLevel = settingsState.themeContrastLevel,
        style = settingsState.themeStyle,
        isInvertColors = settingsState.isInvertThemeColors,
        content = content
    )
}
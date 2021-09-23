# Jetpack Compose Buttons Group

Android library providing a Buttons Group for Jetpack Compose.

[![chargemap](https://github.com/chargemap.png?size=50)](https://chargemap.com)

[![Maven version](https://img.shields.io/maven-central/v/com.chargemap.compose/buttonsgroup?style=for-the-badge)](https://maven-badges.herokuapp.com/maven-central/com.chargemap.compose/buttonsgroup)

![License MIT](https://img.shields.io/badge/MIT-342e38?style=flat-square&label=License)
![Android minimuml version](https://img.shields.io/badge/21+-342e38?style=flat-square&label=Minimum&logo=android)

## Showcase

<img src="art/showcase.png" width="250"/>

## Installation

In your **module** *build.gradle* :

```
dependencies {
  implementation "com.chargemap.compose:buttonsgroup:latestVersion"
}
```

## Usage

### Simple ButtonsGroup

```
var buttonsGroup by remember { mutableStateOf(3) }

ButtonsGroup(
    modifier = Modifier
        .fillMaxWidth(),
    size = 5,
    strokeWidth = 1.dp,
    strokeColors = StateColors(Color.Magenta, Color.DarkGray.copy(alpha = 0.75f)),
    backgroundColors = StateColors(Color.Magenta, Color.DarkGray.copy(alpha = 0.75f)),
    value = buttonsGroup,
    onValueChange = {
        buttonsGroup = it
    }
) {
    Text("Button $it")
}

```

## Contributors

| [![raphaël](https://github.com/r4phab.png?size=120)](https://github.com/r4phab) | [Raphaël Bertin](https://github.com/r4phab) |
|:------------------------------------------------------------------------------:|--------------|

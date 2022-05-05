# Jetpack Compose Buttons Group

Android library providing a Buttons Group for Jetpack Compose.

[![chargemap](https://github.com/chargemap.png?size=50)](https://chargemap.com)

[![Maven version](https://img.shields.io/maven-central/v/com.chargemap.compose/buttonsgroup?style=for-the-badge)](https://mvnrepository.com/artifact/com.chargemap.compose/buttonsgroup)

![License MIT](https://img.shields.io/badge/MIT-9E9F9F?style=flat-square&label=License)
![Android minimuml version](https://img.shields.io/badge/21+-9E9F9F?style=flat-square&label=Minimum&logo=android)

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

You may use any type of list to provide the group values. 
Here is an example with Integers : 

```
var state by remember { mutableStateOf(3) }

ButtonsGroup(
    modifier = Modifier
        .fillMaxWidth(),
    values = IntRange(0, 3).toList(),
    strokeWidth = 1.dp,
    strokeColors = StateColors(Color.Magenta, Color.DarkGray.copy(alpha = 0.75f)),
    backgroundColors = StateColors(Color.Magenta, Color.DarkGray.copy(alpha = 0.75f)),
    value = state,
    onValueChange = {
        state = it
    }
) {
    Text("Button $it")
}

```

## Contributors

| [![chargemap](https://github.com/chargemap.png?size=50)](https://github.com/chargemap) | [Chargemap](https://github.com/chargemap) | Author |
|--------------|--------------|--------------|

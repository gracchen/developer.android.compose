### Compose Quadrant:

solution source code: https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/blob/main/Unit%201/Pathway%203/ComposeQuadrant/app/src/main/java/com/example/composequadrant/MainActivity.kt

what I learned:

modifier.weight(1f) for each of elements in a col / row for equal distribution of space

background color for col:  Column(modifier = modifier.background(backgroundColor) { }

background color for surface:  Surface(color = backgroundColor) { }

break repetitive formating into functions @Composable

to pass down weighting from parent to children (since weight doesn't work if put into each individiual child alone), pass modifier into function

### Task Manager:

soln src code: https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/blob/main/Unit%201/Pathway%203/TaskCompleted/app/src/main/java/com/example/taskcompleted/MainActivity.kt

what I learned:

fontWeight = FontWeight.Bold  (annoying capitalize easily typoed)
fontSize = 16.sp

### Compose Article:

soln src code: https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/blob/main/Unit%201/Pathway%203/ComposeArticle/app/src/main/java/com/example/composearticle/MainActivity.kt

what I learned:

modifier.fillMaxSize()
textAlign = TextAlign.Justify
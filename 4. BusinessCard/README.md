how to resize image:
set image's modifier.height(16.dp)
then set contentScale = ContentScale.FillHeight

how to left-align the 3 contact info rows:
make column NOT fillWidth() and NOT centered (left-align)
put that column inside another container that has modifier centering

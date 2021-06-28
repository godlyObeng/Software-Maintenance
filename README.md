# Software Maintenance CW2

For this project, I have made some maintenance and improvements. I made sure that all the classes
were in one package and all the resources also in another package. After doing this, I changed
the package name declared in all the classes to the one I created and tested the project to make
sure the game was working as it was. After this, I moved the classes into different packages
according to what the class was doing. I also changed the file path for all the resources in
the classes. I realised there were a lot of redundant methods, commented out code and quite
a lot of bugs. I removed the commented-out code for each of the classes after doing this, I started
to work on removing redundant methods from the classes. I made sure these weren’t affecting the software
in any way and they will also not affect future extensions and maintenance. After running the game and
looking at the screenshot of the game from GitHub, I realised the background of the game wasn’t working
so I looked through the resources and found that the filename has been put wrongly in the main class.
I changed it to the correct filename and tested it to make sure it was the right one. There was excess
space in the game window which was showing a white background. I changed the dimensions of the game
described in the background and main class so that all the white space will be removed from the game.
This will prevent distractions and prevent the game from looking unfinished. I also removed the spaces in
the filename of the theme song due to runtime errors it was causing. An extension I made was to move the
game controls from A, S, D, E to the arrow keys. This is because the original controls for the game are
not intuitive and easy to use compared to traditional arrow keys. I also changed where the game points
appear from the top corner to the bottom so that its out of the way when playing the game. There was a
bug in the game when the last end is about to be filled by the frog, it gets stuck in an infinite loop.
I fixed this by removing an if condition located in the Animal class which was calculating the points.
There was also no window title and I added one. I also made the game window not to be resizable to focus
on only the game and since there is nothing around the game stage, it will not make sense for the game
to be played in full screen or any other size. As an extension, I changed the position of the turtles
and added more turtles for the first level to make the game less challenging. The logs also had to be
changed to accommodate the changes of the turtles. As an extension, I changed the background image of
the game since it looked too outdated into a better looking one which looks more modern to improve the
graphics of the game. I also added more scenes to the stage. These are the how to play scene, the game
scene and score ranking scene.
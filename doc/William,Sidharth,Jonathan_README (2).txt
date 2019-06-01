College Admissions 2019
William Xu, Sidharth Kumar, and Jonathan Joanny


Description/Introduction:
You are a high school student at [B]omestead High School. You are applying to prestigious and selective colleges such as Barvard, but three years of your high school career have already passed. The only thing that you do is prepare in the little time that you have and apply to the colleges that you dream of. Lots of stuff can get in your way though. Your parents have various intentions for you that may or may not reflect your own ideas. Applying to college is super stressful, and you’re going to have to work very hard to submit all your stuff. The only thing you can do is do your best and hope to get into the college of your dreams. The game was created for entertainment purposes and for the enjoyment of the user. It also teaches the user a little about the college admission process, and the factors that go into it. The nuances created by the game also reflects upon the issues that may affect students. However much that is displayed in the game itself shouldn’t be taken too literally.


Instructions:                            
The game presents itself in a series of tabs. It starts with a menu tab that reveals some basic instructions, and then directs the user to a tab that represents High School. On that tab, the user can make various decisions by clicking on different buttons(this game consists entirely of button clicks). The user can buy items in a store that will upgrade their hidden features(ie intelligence, happiness). Every decision the user makes affects one of the user’s variables, and all these factors play a role in whether or not the user gets “accepted” into colleges.


Features List:
Must-Have Features:
Menu with instructions given to user---Completed(the Intro panel is the menu, and once the “start game” button is pressed, instructions are given to the user via a popup)
Characters are randomly created and displayed on screen with a character icon. The characters have stats such as GPA, test scores, etc---Completed(Upon clicking “start button”, a character is created for the user, and initialized with random variables such as intelligence. The character icon is displayed on the HighSchoolPanel, and it changes depending on the character’s “personality”, or happiness)
Various Options given to users at given stages in the game---Completed(The HighSchoolPanel presents multiple options for the user to do in school, such as playing sports and studying)
The application portal, where the user can “apply” to various colleges(there is a list of colleges the user can apply to)---Completed(The ApplicationPanel has buttons that show where the user can apply(for a fee))
A result page, where the user learns of the results of their college application process---Completed(Currently, the result page displays confetti as well as text that shows which colleges the user got into)


Want-to-Have Features:
User variables: Personality bar: shows how happy/sad the user’s character is -- completed(bar that shows player happiness is displayed on main game screen) 
Pop-ups whenever unexpected events happen(ie admission rescinded for lying on app, bribing college officials, application sent in too late, etc) -- Completed(The LuckBasedEvent class generates random events that can either be good or bad for the user’s college prospects)
Hidden “fortune” stat which also affects the character’s decisions and the outcomes -- Completed(The user’s luck stat controls how likely they are to get good or bad luck-based events)
Store(money spent on applying to college, buying tutors/books, even bribing college)---Completed(The store is represented by a tab which gives the user options of purchasing different types of goods/services)
At the end of the game the user receives all the decisions that they made, and a score based on an algorithm for “success”


Stretch Features:
Minigame-ish stuff that allows the user to upgrade their character(that represent real life scenarios like extracurriculars) -- NOT COMPLETED
College advisor that can be purchased with money(can give good or bad advice based on how expensive it is)---Completed(The CollegeAdvisor gives popups to the user that represent college-related advice)
Player can choose good or bad life decisions in high school -- NOT COMPLETED
Parents that pressure the user into making various decisions -- NOT COMPLETED
Networks so the user can compete against other users -- Completed ( student can see stats of other students and their college result outcomes) 


Class List:
Main- contains the main method
WholeUI - contains all the different gamepanels that make up the game
Character(a student applying for college that the user plays as), is created randomly once game starts with various different characteristics such as
Gamepanel - a default panel upon which we can extend and draw things on it later        
MenuPanel - an intro panel that contains a button to start the game. Once this button is clicked, instructions are loaded.
ApplicationPanel - a game panel in which the user’s college app information, and a variety of colleges, is displayed
HighSchoolPanel - a game panel in which the user can interact with “high school” and make decisions
GameTimer - a timerTask that decrements the time remaining for the user in HighSchoolPanel every time it runs
MenuPanel - the loading screen that has instructions on how to play, and the option to start the game
Resultpanel - the panel that is displayed when the user receives their user results
Store- the panel that displays objects the user can buy, and options to buy them
Transcript - displays the courses that the user has took, and the grades the user has recieved in them
LuckBasedEvent - a class that generates events that can be “lucky” or “unlucky” based on the user’s luck statistic
CollegeAdvisor(stretch) - a advisor that the user can purchase, which gives popups representing college “advice” to the user
College - college objects that differ by selection factors like GPA, extracurriculars, etc. They are displayed in the Applicationpanel
TabSwitcher - the interface that allows us to switch tabs in this program
Leaderboard - displays the outcomes of other players who use the simulator
Firebaseclient - used to interact with database, add and read the stats of players of the game
Student- used to model other students from the json saved in database




Credit:


Sidharth : Main, GamePanel, DrawingSurface, Transcript , firebaseclient, student, Leaderboard, external libraries, GIFs,  wrote README
William: HighSchoolPanel, ApplicationPanel, Character, LuckBasedEvent, College, GameTimer, made UML
Johnny: TabSwitcher, WholeUI, Store, CollegeAdvisor, images


Sources
Library Image from: https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjCvqGikL3iAhXVGDQIHcmZDFgQjRx6BAgBEAU&url=https%3A%2F%2Flithub.com%2Fon-the-experience-of-entering-a-bookstore-in-your-forties-vs-your-twenties%2F&psig=AOvVaw0rYoydJOgGLhRERsIDSfBo&ust=1559095174153088
Loading gif from https://loading.io/spinner/dual-ring/
Confetti gif from https://media3.giphy.com/media/9u2VQAwIgpMZKT6qTV/source.gif
Jackson json api for parsing json: https://github.com/FasterXML/jackson
Firebase for hosting database of scores: https://firebase.google.com/
Material design swing look and feel from https://github.com/atarw/material-ui-swing


Help:
Sidharth’s dad for help with posting, and setup of jackson (firebaseclient class)
Maxim Bravo(Grade 11) helped William create the pause button on the HighSchoolPanel
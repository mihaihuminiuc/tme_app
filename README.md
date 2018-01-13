Android developer test

Hi there! If we got this far, it means we really like you and would love you to join our team. 

We believe in commitments and our plan is to make a long term commitment to you that we’ll provide a challenging, entertaining and most of all stable work environment. 

Since we don’t like to make promises we can’t keep, we need to make sure your skill level is on par with our expectations. This way, we’ll be confident in making this commitment to you. 

Nothing in this test is mandatory. Please do as much as you are willing to do and we will do our best to evaluate you based on that. We’d rather you complete all three tasks but if you feel you’ve done a great job with just one of them, it might be enough. 

The average time it took our developers to do each task is mentioned in parenthesis.
Good luck!

1. Loading remote data & grid views  
Build an app that loads a list of wallpapers from a remote URL and displays them in a grid. Your app will have 2 buttons. Add a full page loading screen until the request for the wallpapers list is complete. 
The first button will show a fragment (full screen) that will display the list of wallpapers as thumbnails in a grid, 2 per row. The fragment will have a header with a title (Wallpapers) that will take ¼ of the screen. Each cell in the grid should have a yellow border. When an item is clicked, the full wallpaper URL should open in the default system browser. 

The second button will open another Activity that will display the same list of wallpapers in a grid, 3 per row, but the cell border should be blue. When an item is clicked, the wallpaper URL should be shown in a toast message. This fragment will have no header, but it should have a FAB that, when clicked, copies one random wallpaper in a new grid cell, at the beginning/top of the grid. When re-opening the app (force-close app, then reopen) both fragments should still contain these manually-created items, in the same position. 

Remote API URL: http://api.timmystudios.com/api/android/wallpapers.json

2. Ad mediation 

“Ad mediation” is a feature that allows app developers to serve ads from multiple ad networks by sending requests to all of them and choosing the best one to show to the user. Sometimes, an ad network will not return an ad, either because of an error, or because it simply does not have any ads available for the current user.

For this test, the ad networks are AdMob and Facebook and the criteria is loading speed. That means that whenever you decide to show an ad, you should request ads from both AdMob and Facebook and as soon as one of them responds with an ad, you show it.

For this test, you have to insert an interstitial ad in between a user action and his desired outcome in a very simple app: one activity with one central button. 
On app start: when the user opens the app, he should see an interstitial before being able to use the app. You should show a loader while the user waits for the ad networks to respond.

The loader should disappear 
when the interstitial is shown 
OR 
when both ad networks have failed to return an ad 
OR
if more than 10 seconds passed since first showing the loader


On button click: When the user clicks the central button, his intended outcome is to see a toast message saying “button was clicked”. However, you should interrupt the user experience with an interstitial. The toast message would show after the interstitial is dismissed OR if none of the ad networks returned an ad. 
If you finished Task 1 (loading remote data and grid views) feel free to implement Task 2 (Ad mediation) in the same project since you already have buttons and a loading screen.

Package name of the app should be: com.gau.go.launcherex.theme.launcherthemescute. If you use a different package name, facebook will always fail.
AdMob placement ID: ca-app-pub-3188130179542594/8777728066
Facebook placement ID: 1907562002857126_1907565212856805
Tip: to force an ad network to not return an ad, use an invalid ad placement ID.


3. Advertising ID 
Create an activity with a switch, a button and a text view. Each button press will result in a string being added into an array containing all the strings from all the button presses. Also, each button press will update the text view with the count of strings in the array. 
If the switch is off and the user presses the button, the new string added to the array will be like “day.month.year.<ADVERTISING_ID>” , where ADVERTISING_ID can be taken from AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
If the switch is on and the user presses the button, the new string added to the array will be like “day.month.year.<phone_model>”.

The purpose of this exercise is to see how well you organize your code. Switch on/off is a simple example with only two possible states, but try to organize your code with scalability in mind. More specifically, think about how you would organize your code if the decision of which string to add would depend not on a boolean, but on an integer with possible values 0, 1 or 2, and when the variable is equal with 2, you need to add a string that represents, as an example,  cpu.AVERAGE_CPU_USAGE_MEASURED_AT_5_SECONDS 


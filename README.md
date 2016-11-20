## Inspiration

I've always tried to organize basketball between my friends when they drop by Toronto. Between the TTC being unreliable, the natural tardiness of some, and unforeseen events, I'd often end up with half-full teams and a lot of frustration. I've thought about asking people to join us for pick-up basketball, but I can't walk away from the court, or some other kids will take it for themselves.

As a team, we were inspired by the huge success of Pokemon Go. We thought outside the box, and incorporated the idea of geographical game-play with open sports games. We 'gamified' pick-up games, so while you're walking down the street, you're able to check out nearby sports games (soccer, basketball, tennis, etc.) and drop by when you're free. This way, we're finally able to solve the problem of getting more people to play sports with, while encouraging everyone to get out and about and make new friends.

## What it does

Sportigo encourages exploration and exercise through a Google Maps view of your current location. Markers around you (within a certain distance that you may specify) which indicate local sports events near you. You can click on any event to view more information, register for it, and even get specific directions to the event. We've even built a chat-room so you can get to know each other, and hopefully you'll never show up to a volleyball game without a game ball again, either!

You're able to specify what sports you love, so you can be alerted via Push Notification when an event pops up near your proximity. If you're someone who doesn't mind traveling, you can also specify a range for Sportigo so you can find events up to 100km away from yourself. If you're planning a sporting event, you no longer have to be restricted by how many people you know - you can invite the whole wide world via Sportigo.

## How we built it

We built Sportigo on the Android platform by using Android Studio. Primarily, the back-end of the application is run on Google Firebase. We use Firebase for as a Real-Time Database, so that any events created will simultaneously be synced on every phone. With Firebase Cloud Messaging, we also give Push Notifications to event creators when new users sign up for their events. We also rely on Firebase to run our chat system, allowing effective and constant communications between all parties involved.

## Challenges we ran into

*   Initial issues committing to GitHub
*   Android Studio List View not populating elements
*   Trying to emulate Android phone to allow Dangerous permissions, but discovering that it cannot be emulated and will always be denied (read: crashing continuously for hours despite troubleshooting)
*   Backwards and forwards compatibility between ADK v.21 and v.23 (especially with permissions and Dangerous/Normal permissions)

## Accomplishments that we're proud of

We successfully got Firebase to work although we've never used it before (shoutout to documentation) We FINALLY got the Google Maps API to work by using a real phone, after LONG HOURS Our Teamwork <3

## What we learned

We learned a lot about Material Design, Firebase, and Google Maps API and something called Haversine (distance calculation vector between two long/lat points). Who knew math would be useful! Euck.

## What's next for Sportigo

*   Introduce iOS version of Sportigo
*   Add additional functionality to application like 'Add Friend'
*   Twilio-masked calling between users to remain anonymous
*   Multilingual support
*   More options for customization (different event colors, backgrounds, etc.)
*   Location and Sports-based channels (e.g. Basketball [Toronto], or Scarborough channels for all sports)
*   Monetization model through advertisements that don't disrupt usability

# Activities and Intents

## Learning Objectives

* Learn what an activity is
* Learn how to add a new activity to an app
* Learn what an intent is
* Learn how to pass data between activities using intents

## Acitivities and Intents
So far we have one 'page' or 'activity' in our app and our screen is starting to look a little 'busy'. Wouldn't it be be nice if we could enter our question and then, rather than the answer being displayed in the same screen, we were taken to a new screen which displayed the answer.

So how do we do this?

As we said earlier, Android has this idea of "activities" and "intents". It is these concepts we are going to make use of.

## Activities

We will start by creating a new activity. An activity is basically an individual screen in your app which is responsible for drawing its components and controlling its logic. In our ```MagicEightBall``` app we currently only have one activity called ```EightBallActivity```. Since we want the answer to appear on a screen separately to where the user enters their question, we need to create a new activity.

As this new screen is going to display the answer, we can call this ```AnswerActivity```.

## Setting up a new activity
Just like we did with the first activity, we want to create a new empty activity using the file tree.

- Right click the package folder within the Java folder.
- Navigate to New > Activity > Empty Activity.
- Name the activity `AnswerActivity`.
- Make sure the `Generate Layout File` box is checked.
- Ensure the layout name is `activity_answer`.
- Make sure that `Backwards Compatibility` is checked.


Doing this will generate two files, and edit one:

Created:

- `AnswerActivity.java`
- `activity_answer.xml`

Edited:

- `AndroidManifest.xml`

### Changes to the manifest

If you look in the `AndroidManifest.xml` file after you create a new activity, you will notice that something has been added.

Below the first activity tag, there is another, however this time it has a lot less inside the opening tag. This is because the first activity was firstly set to LAUNCHER, and secondly it was set to the MAIN activity because it was first.

The new tag only has a name, but we want to add a *little* more, it currently looks like:

```xml
<activity android:name=".AnswerActivity"></activity>
```

However we want to add a litte more - we want to add a label to appear at the top of the screen when the user is looking at it, and we want to add a parent activity.

The parent activity will tell Android where to go back to when the back button is pressed at the top of the screen.

```xml
<activity
    android:name=".AnswerActivity"
    android:label="@string/answer_activity_title"
    android:parentActivityName=".EightBallActivity">
</activity>
```

Note: the `@string/answer_activity_title` will appear red as there is no string resource for it yet. To remedy this, all that must be done is to press `alt-enter` when the cursor is somewhere on the `@string/answer_activity_title`, and select create resource, filling in the resource value and clicking okay.

### Generated files

The other two files which Android Studio generates are the same as the ones we saw with the original `EightBallActivity`, apart from the layout that gets set in the `setContentView` method. (And of course the names of the files!)

## Moving the answer TextView into the new activity

Previously we had it so that the random answer appeared in the TextView in the `EightBallActivity`, however now we want the answer to appear in the new activity we just created.

Since we don't need the TextView in the `activity_eight_ball.xml`, we can delete it, and any references to it in the `EightBallActivity.java`. We can also remove all the logic for getting the random answer from our models.

After we remove that, we can move into our `answer_activity.xml` file to start designing the UI.

All we really need for this activity is two TextViews:

- One to show the question asked.
- One to show the answer.

Create two TextViews in the layout and give them ***Unique*** Ids. Ensure their Ids don't conflict with the Ids of the components in the `activity_eight_ball.xml`.

We will come back to using these Ids after we look at moving between activities and intents.

## Allowing the user to move between activities

### Intents

Intents sit between the operating system of the device, and the activities in your app. Intents tell the operating system that we want to move the user to a new activity, and what data to send to the new activity.
They are objects used for communication between the operating system and components, the only component you've seen are activities, however there are more which you may use if you explore Android further.

Intents can be used for much more than navigation, and their constructors change depending on what you want to use them for.

The constructor we use it:

```java
    public Intent(Context packageContext, Class<?> class)
```

The `class` is used to tell the operating system which activity you want to create/navigate to, and the `packageContext` is used to tell the operating system where you are, what you are, and what permissions you have. This is so that the operating system can make a decision on whether to let you do what you're asking.

### Using the intent in EightBallActivity

For a start, we don't need to worry about passing data between our activities, instead let's focus on getting the navigation working first.

In order to navigate using an intent, you must first create the intent that you *intend* to use.

In `EightBallActivity.java`, add this line in the now blank `onShakeButtonClicked` method:

```java
public void onShakeButtonClicked(View button) {
    Intent intent = new Intent(this, AnswerActivity.class);
}
```

This creates a new intent, passing `this` as the context, and passing the `AnswerActivity` class as the 'destination'.
This simply creates the intent, and doesn't actually do any action. To actually navigate to the new activity, you must start it. Add this line too.


```java
public void onShakeButtonClicked(View button) {
    Intent intent = new Intent(this, AnswerActivity.class);
    startActivity(intent); // NEW
}
```

This tells the operating system start a new activity using the intent we created.

So let's **run the app**, you'll see that when you press the `SHAKE` button, you are brought to a new activity, but at the moment there is nothing on it. So we need to find a way to bring the question from the `EightBallActivity` to the `AnswerActivity` to show the question after it has been asked.

## Passing data between activities using intents

### Sending the data as an extra

Intents are very versatile, and allow us to do a lot of things other than start new activities: one of these things is to attach some *extras* to the intent before we start an activity, then get the extras back once we are in the new activity.

When we bundle extras, it's super important that we do it ***before*** we use `startActivity(Intent intent)`.

To add some extras to an intent, the method `intent.putExtra(String key, Serializable value)` is used.
Since we're just going ot be sending strings, there is no need to worry about the `Seriablizable` interface, as strings are already serialized.

In our code, we need to use the method in our `onShakeButtonClicked` method.

Add this line in ***before*** we use `startActivity`, but ***after*** we create the intent.


```java
public void onShakeButtonClicked(View button) {
    Intent intent = new Intent(this, AnswerActivity.class);
    
    String userQuestion = questionEditText.getText().toString(); // NEW
    intent.putExtra("question", userQuestion); // NEW
    
    startActivity(intent);
}
```

This will bundle the users question in with the intent, which will be carried over when the user moves to the `AnswerActivity`.

### Retrieving the data from the extras bundle

So sending data on an intent is quite simple, just one `.putExtra` method.
However, things get a little more complicated when we want to get the data out on the other side.

The extras live inside a `Bundle` called extras, inside the intent.
There are a few steps to retrieving our data:

- Get the intent in the new activity
- Get the extras bundle from the intent
- Get the specific extra from the extras bundle

In our code, this means that we need to add these lines of code into our `AnswerActivity`, inside the `onCreate`, after the code that Android Studio generated for us:

```java
Intent intent = new Intent(); // Gets the intent that brought the user to here

Bundle extras = intent.getExtras(); // Gets the bundle of extras which were put on the intent in EightBallModel

String question = extras.getString("question"); // Uses the key that was put in the EightBallModel to retrieve the question which the used entered
```

### Generating a random answer

So now we have the question the user asked in a variable called `question`, the next thing we need to do is get a random answer.

Use the model we wrote to get a random answer and save it in a variable.

```java
Answering answers = new Answers();

String answer = answers.getRandomAnswer();
```

Note: The way in which you use the model may vary, depending on how it was written.

### Showing the question and answer to the user

In order to show the question to the user, we must get a hold of the components:

Firstly we need to declare the component variables above the `onCreate`:

```java
public class AnswerActivity extends AppCompat {
    TextView questionText;
    TextView answerText;
```

After that, we must use `findViewById` to get a hold of the components in the layout, we can do this just above the line of code where we get the intent:

```java
setContentView(R.layout.activity_answer);

questionText = (TextView) findViewById(R.id.question_text); // NEW
answertext = (TextView) findViewById(R.id.answer_text); // NEW

Intent intent = new Intent();

Bundle extras = intent.getExtras();
```

The last step is to set the text of these TextViews to be the question and the answer.
We can do this at the end of the `onCreate` method.

```java
String answer = answers.getRandomAnswer();

questionText.setText(question); // NEW
answerText.setText(answer); // NEW
```

Run the app and you should have a fully working Eight Ball App!
Congratulations!
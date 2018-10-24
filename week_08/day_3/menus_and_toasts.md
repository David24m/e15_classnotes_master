# Creating a Menu

## Learning Outcomes

* Add a menu to the actionbar in an Android App
* Display a toast when the menu item is selected
* Create a second menu item to take the user to a *secret* activity

## Menus

If you've ever used a mobile app, you've probably noticed that it probably has a menu in some place, sliding menus, option menus, the list goes on.
In this lesson we are going to create a simple options menu which will appear when the user taps an icon on the right of the actionbar.

## Creating a menu

### Creating the resource file

When we want to create a menu, the first thing we must do is create an XML resource file for it. Although the resource will use XML components and live in the `res` folder, we will not be creating it in the layout folder. We must create a new folder in the `res`.

Create a folder in the `res` folder called `menu` (`/res/menu`).

- Right click the `res` folder in the file tree.
- Select the `New > Android Resource Directory` option in the menu.
- Change the drop down for resource type to `menu`.
    - This should change the name of the resource folder to `menu`.
- Click finish.

After we have that folder in place, we need to create our resource file for our menu. When we name this file, we want it to match the name of the activity layout file for that activity that the menu will appear on.

Create a menu resource file in the `res/menu` folder.

- Right click the `menu` folder in the `res` folder.
- Select the `New > Menu Resource File` option in the menu.
- Name the file `activity_eight_ball`, as to match the name of the layout file for the `EightBallActivity`.
- Click finish.

### Adding menu items to the resource file

At the moment, our menu is empty, there are no options for our user to select, we need to change that.
You should notice that the component palette on the left of the design view has a much shorter list of components for you to choose from.

The most basic of these components is the `item` component. We can drag one of those anywhere onto our screen and release our mouse, this will automatically append the component to the menu in the position it should be in.

We must give it an Id and a title, so that we can use it in the Java code, and so that the user can see what it can do.

Change the title property of the `item` to `@string/make_toast_label`.
This will cause a rendering error as the string resource with that name doesn't exist, so create it using the text view like you have before. Set the value to something like `Here's a toast!`.

Set the Id to something like `action_toast`. We put action before the Id because selecting the item will cause an action.

If we ran the app now, the menu still wouldn't appear, we need to do some Java before we get to that stage!

### Inflating the menu

So as we see if we run the app, despite having the menu resource file with the same name as the activity's layout resource file, the menu will not show.
This is because we need to use Java to tell the activity to create (inflate) the menu.

To do this we can use a lifecycle hook, kind of like `onCreate`, the method we want to override is called `onCreateOptionsMenu`.

Let's override that method now, so in the `EightBallActivity.java` we want to add:

```java
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    
}
```

This is how the method that we want to override looks, it's the way it is because that's how Google decided it would be when they made android.

In order to actually get our menu to show, we need to ***inflate*** it. We do this by using a class which android provides for us called the `MenuInflater`.
We must first get the menu inflator for this activity, then use the `.inflate` method on it afterwards.

In the `onCreateOptionsMenu` method, add this:

```java
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.activity_eight_ball, menu);
    return true;
}
```

We need to return true at the end because we told android that our method returns a boolean, which is how it ***must*** be.

Now when we run our app, we can see a menu display when we tap the three dots icon at the otp of the screen, and we can see our option. However when we tap it, nothing happens, because we haven't yet told it to do anything.

### Doing things when options are selected

Just like when we inflate a menu, when a user selects an option in the menu, we can override a method to change what happens to what we want to happen.

The method we are to override is called `onOptionsItemSelected`, so add this code to `EightBallActivity.java`:

```java
@Override
public boolean onOptionsItemSelected(MenuItem item) {

}
```

This method also returns a boolean, and takes in a `MenuItem`, the `MenuItem` which it takes in is the one which the user selects, so we can use its Id to check which `MenuItem` they have selected.

The first instinct may be to use an if statement, then more when we add more options, however this will get pretty mess pretty quickly, so a ***switch*** statement fits a little better.

```java
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int selectedItemId = item.getItemId();
    switch (selectedItemId) {
        case R.id.action_toast:
            makeToast("I am a toast!", Toast.LENGTH_SHORT);
            return true;
    }
    
    return super.onOptionsItemSelected(item);
}
```

When this code is entered `makeToast` will turn red, as that method doesn't exist yet. We need to write it.

We ***could*** write the code to create and show a toast directly in the case, however this will make this switch statement quite large, and we can easily take the code and move it into a separate function. So let's write that.

## Toasts

### Creating the toast

Toasts are little messages that appear at the bottom of the screen with a message for a set amount of time, the code that you must use to create them isn't too complex, so let's have a crack at it.

Add this method into `EightBallActivity.java`:

```java
public void makeToast(String message, int length) {
    Toast.makeText(this, message, length).show();
}
```

This method will create a show a toast with a custom message, for a passed in amount of time.

Note: `Toast.LENGTH_SHORT` and `Toast.LENGTH_LONG` are constant `int`s in the `Toast` class, they are just ints.

Run the app now, and selected the option `Here's a toast!` in the menu, you should see a message appear at the bottom with the `I am a toast!` message for a short time.

## Using a new option to move to the *secret* activity

### Creating the menu item

Once again we want to jump into our `menu/activity_eight_ball.xml`and add an `item` component to the menu, drag it over and we can start modifying its properties.

Just like before we need to give it an Id and a title:

- Id: `action_secret_activity`
- Title: `Can you keep a secret?`
    - Remember to make the title string an `@string/` resource.

So that's our option created, let's make it do something in the Java code!

### Creating the *secret* activity

So like we have a number of times now, we need to create a new activity.

##### TASK:
Create a new activity called `SecretActivity` which simply has one `TextView` component with the text `@string/secret_text` with the value of something like `JavaScript is the best language, shh, don't tell Java`.

### Using the option in the menu to start the *secret* activity

Since we can execute any code when a user selects a menu item, we can simply use the normal method of activity navigation to move to our new activity.

First we need to add a new case to our switch statement, since we added a new menu option, we need to add the code to handle what happens when a user selects it.

Add this case to your switch statement:

Note: The method we want to use hasn't been written yet, so it will turn red in the editor. 

```java
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int selectedItemId = item.getItemId();
    switch (selectedItemId) {
        case R.id.action_toast:
            makeToast("I am a toast!", Toast.LENGTH_SHORT);
            return true;
        case R.id.action_secret_activity: // NEW
            goToSecretActivity();         // NEW
            return true;                  // NEW
    }
    
    return super.onOptionsItemSelected(item);
}
```

The last thing we need to do is to write the method `goToSecretActivity()`, all that it's going to do is create an `Intent` to move to the secret activity, then start the activity using that intent.

##### TASK:
Create the `goToSecretActivity()` method, making it move the user to the `SecretActivity`.

The solution to this:

```java
public void goToSecretActivity() {
    Intent intent = new Intent(this, SecretActivity.class);
    startActivity(intent);
}
```

Run the app, you should now have a menu with two options, one to create a toast, and the other to move to the secret activity with the secret message!
Congratulations!

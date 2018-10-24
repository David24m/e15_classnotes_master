# Piggy Bank Application

## Learning Objectives
- Create a single component application
- Introduction to props and state
- Install the React Dev Tools and learn how they can be useful

## Creating the Piggy Bank Component
We want a simple piggy bank application to get to learn the syntax of React. We want to be able to put money in, take money out, and see the total.

It will contain a single piggy bank component that will display a savings total.  We will then add a 'deposit' button that will update the state of the component, updating the total.

A component's role is to display a section of our user interface.  Good React applications have many small components each doing one job, much like good OO programs.

> Hand out react_startpoint

Let's install and start our app:

```bash
# terminal - top level
npm install
npm start

cd client
npm install
npm start
```

```bash
# terminal
mkdir src/components
cd src/components
touch PiggyBank.jsx
```

To create our components we use ES6 classes which inherit from React.Component. We can then define methods inside our classes.

The main one which we must always include is a ***render*** method. This returns a single element to be rendered to the page. You may nest multiple elements in the render but they must always be wrapped inside a single containing element.

```js
//client/src/components/PiggyBank.jsx

import React from 'react';

class PiggyBank extends React.Component {

  render() {
    return (
      <div className="bank-box">
        Hello, world! I am a Piggy Bank.
      </div>
    );
  }

}

export default PiggyBank;

```


Remember to `export default` so we can `import` it elsewhere!

```js
//client/src/app.js

import React from 'react';
import ReactDOM from 'react-dom';

import PiggyBank from './components/PiggyBank';

window.onload = function() {
  ReactDOM.render(
    <PiggyBank />,
    document.getElementById('app')
  );
}
```

Components have attributes that they can display.  There are two types of attributes.

## Properties
Properties are attributes that are given to a component that can not change. They are immutable.  They just render it.  Let's give the piggy bank a title component that it can display.

We pass in properties to JSX like we set attributes on an HTML component. These can be in quotes to pass in a string, or in curly braces {} to pass in other JavaScript data types or objects. (Can show this transpiled by Babel to show what's happening). Note: all JSX tags must be closed, either with a separate closing tag or self-closed.

```js
//client/src/app.js

  window.onload = function(){
    ReactDOM.render(
      <PiggyBank title="Beth's Savings Pig" />,
      document.getElementById('app')
    );
  }
```

Our component has use of its properties through its props attribute,  this.props.
Let's use it to show our title.

```js
//client/src/components/PiggyBank.jsx

  class PiggyBank extends React.Component {
    render() {
      return(
          <div className="bank-box">
            <h1>{this.props.title}</h1>
          </div>
      );
    }

  });

```

## State - Displaying a total

Now we want our bank to display a total.  Props are something that are given to us by a parent that we can't change.  We need something that belongs to the component that it can change.

State is something that the component is in control of. It generally isn't passed down from a parent,  it is something the component sets up itself.

Let's set up our initial state. We want a total property that starts at zero. We can then display this. Our initial state is defined in the constructor of our component class.

```js
//client/src/components/PiggyBank.jsx

class PiggyBank extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      total: 0
    }
  }

  render() {
      <div className="bank-box">
        <h1>{this.props.title}</h1>
        <p>Hello, world! I am a Piggy Bank.</p>
        <p>I contain £{this.state.total}</p>
      </div>
  }
}

```

## Changing state.

Now we want to add a button that will increase the total when we deposit money into the piggy bank.

Clicking on the button will update the state of our application. We will use the this.setState() method to update the state.

When updating the state of a component, if its value changes, React will re-render the application!

Seems a bit inefficient but remember the virtual DOM!  React will only update the DOM elements that have changed, keeping it quick.

```js
//client/src/components/PiggyBank.jsx

class PiggyBank extends React.Component {

  constructor(props) {
    ...
  }

  addToSavings() {
    this.setState((prevState) => {
      return {total: prevState.total + 1};
    });
  }

  render() {
    return (
      <div>
      ...
      <button onClick={ this.addToSavings }>Add</button>
      </div>
    );
  }
}
```

Unfortunately, we've run into a problem with `this`. Inside `addToSavings`, `this` has global scope. Which is bad. Fortunately, there are a couple of solutions to this problem.

Option 1 is to use our old friend `bind`:

```js
  <button onClick={ this.addToSavings.bind(this) }>Add</button>
```

You might also see this happening in the constructor, which is pretty ugly, but it works.

```js
  constructor(props) {
    ...
    this.addToSavings = this.addToSavings.bind(this);
  }
```

Option 2 is to wrap the call to `addToSavings` in an anonymous ES6 arrow function, which does not bind its own `this`:

```js
  <button onClick={ () => { this.addToSavings() } }>Add</button>
```

# Chrome Dev Tools
An other advantage of React is that there are powerful development tools in chrome.
https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi?hl=en

We can see the state and properties of all of our components at any point in time.

We have a dynamically updating single component react application.
We have seen properties and state on a component and how setting the state forces the application to re-render.
Next we will see an application with multiple components that will increase our understanding of the one-way flow.

## Tasks:
- Add an owner property to the piggy bank
- Add a 'withdraw' button which decreases the total.
- Add a depositAmount property - pass in a value which depositing or withdrawing will change the total by.

### Solution:

Add an owner property to the piggy bank:

```html
// index.js
<PiggyBank
    title="Beth's Money Pig"
    owner="Beth" />

// PiggyBank.jsx
<p>Hello, world! I am a Piggy Bank. My owner is {this.props.owner}.</p>
```

Add a 'withdraw' button which decreases the total:

```js

withdraw(){
    this.setState((prevState) => {
      let newTotal = prevState.total < 1 ? 0:prevState.total - this.props.depositAmount;
      return {total: newTotal};
    });
}

render(){
    // ...
    <button onClick={ () => { this.withdraw() } }>Withdraw</button>
    // ...
}
```

Add a depositAmount property - pass in a value which depositing or withdrawing will change the total by.

This is a good opportunity to refactor our code. We can remove the `withdraw` and `addToSavings` methods, and just use one `changeSavingsAmount()` method.

```js
changeSavingsAmount(amount){
    this.setState((prevState) => {
      let newTotal = prevState.total + amount;
      if(newTotal < 0){
          newTotal = 0;
      }
      return {total: newTotal};
    });
}

render(){
    // ...
    <button onClick={ () => { this.changeSavingsAmount(this.props.depositAmount) } }>Add Funds</button>
    <button onClick={ () => { this.changeSavingsAmount(this.props.depositAmount / -1) } }>Withdraw</button>
    // ...
}
```

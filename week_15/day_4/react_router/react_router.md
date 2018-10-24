# React Router

## Learning Objectives
 - Understand how react router works
 - Be able to use react router in a simple application

## Introduction
 Traditional server rendered applications would work by entering the url into the browser address bar, keeping the information and page in sync.  One page applications make the requests asynchronously,  the url therefore will get out of sync with the UI. 

 This makes navigation difficult.  React has a router module which will help us out with this.  Let's first see all the problems we mentioned in action.

# Setup
 Let's set up an application.

 > Hand out the router start point.
 
 > Check links are working.

 Simple application where the Main component keeps hold of the state of the current page of what is showing. It will then switch on this choosing which view should be displayed.

# Task: Checking understanding of current application.
  Add a component and a link for a contact page.

# Adding Router
  So the application is functional, but the url does not match what the UI is showing. And if we leave or refresh the page we will always go to home page regardless where we were. Enter the need for a router.

```
  //client
  npm install --save react-router-dom
```

Let's set up the main page to work as router. We will import our components so we can later pass them in our routes. We will also import HashRouter and Route. 

```jsx
//app.js
import React from 'react'
import { render } from 'react-dom'
import Main from './components/Main.jsx' //UPDATED
import About from './components/About.jsx' //UPDATED
import Home from './components/Home.jsx' //UPDATED
import Pricing from './components/Pricing.jsx' //UPDATED
import { HashRouter, Route } from 'react-router-dom' //UPDATED

window.onload = () => {
  render(( 
    <HashRouter> //UPDATED 
      
    </HashRouter>
    ),
    document.getElementById('app')
  );
}
```

HashRoute will keep track of our navigation through a site. This means now when we refresh it will remember where we were and we can use our browser navigation buttons to go back and forth through our browsing history. 

Now we are going to define our routes inside our HashRouter. We have to wrap them in a `div` because HashRouter only expects one element. Each Routes takes two attributes, a path and a component to render on that path.

```jsx
//app.js
import React from 'react'
import { render } from 'react-dom'
import Main from './components/Main.jsx'
import About from './components/About.jsx'
import Home from './components/Home.jsx'
import Pricing from './components/Pricing.jsx'
import { HashRouter, Route } from 'react-router-dom' 

window.onload = () => {
  render((
    <HashRouter>
      <div> //UPDATED
        <Route path="/" component={Main} /> //UPDATED
        <Route exact path="/" component={Home} /> //UPDATED
      </div> //UPDATED
    </HashRouter>
    ),
    document.getElementById('app')
  );
}
```

We set up a path to '/' to render the Main component whenever we land on localhost:3000/. So this will always render Main, because every route has that path as it's base.

We then set up an an ***exact*** path to render the Home component. This will render the Home component on `localhost:3000/` only.

Next we will define the rest of our routes to render the appropriate component.

```jsx
//app.js
import React from 'react'
import { render } from 'react-dom'
import Main from './components/Main.jsx'
import About from './components/About.jsx'
import Home from './components/Home.jsx'
import Pricing from './components/Pricing.jsx'
import { HashRouter, Route } from 'react-router-dom'

window.onload = () => {
  render(
    <HashRouter>
      <div> 
        <Route path="/" component={Main} /> 
        <Route exact path="/" component={Home} /> 
        <Route path="/home" component={Home} /> //UPDATED
        <Route path="/about" component={About} /> //UPDATED
        <Route path="/pricing" component={Pricing} /> //UPDATED
      </div> 
    </HashRouter>,
    document.getElementById('app')
  );
}
```

We then simplify the Main.jsx. We can delete the imports of our components and import `Link` from react-router-dom. We also now only need to return a list of react-router Links that each have a path.

```jsx
// Main.jsx

import React from 'react'
import {Link} from 'react-router-dom' //UPDATED

class Main extends React.Component {

  render(){
    return(
      <div>
        <h4> Main App</h4>
        <ul>
          <li><Link to="/home">Home</Link></li>
          <li><Link to="/about">About</Link></li>
          <li><Link to="/pricing">Pricing</Link></li>
        </ul>
      </div>
    )
  }

}

export default Main
```

We can see as we navigate through the site the url changes. React-router adds the hash into the url to prevent a new http request.


# Short Task 

Create a new component and add it to the list of links in the Main component
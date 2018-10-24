# Pizza Shop Lab

We're about halfway finished on our RESTful pizza shop web app. We still need to add routes for `edit`, `update` and `delete` actions.

Funnily enough, that's exactly what we're doing in this lab! Go ahead and write these routes and finish our app.

Annoyingly, we can't use DELETE or PUT requests in the browser, we just use POST for them.

Our REST table should then look like this:

|VERB  |PATH              |ACTION |
|:----:|:----------------:|:-----:|
|GET   |/pizzas           |index  |
|GET   |/pizzas/:id       |show   |
|GET   |/pizzas/new       |new    |
|POST  |/pizzas           |create |
|GET   |/pizzas/:id/edit  |edit   |
|POST  |/pizzas/:id       |update |
|POST  |/pizzas/:id/delete|destroy|

All POST routes must be sent from `<form>`s.

## Hints

* Start with the `delete` route. It is the simple one, as it only does one, fairly small thing.
* Although the `delete` route is the least complicated, it relies on a POST request, because it is changing the resource on the server. Unfortunately we can't make a hyperlink to a POST request, we have to use a button inside a `<form>` with its method and action properly set. You saw how to do this in the `new` form. You could put this form on the `show` page for a specific pizza, or on the `index` page if you'd prefer that.
* After the deleting a pizza, it might be sensible to send the user back to the list of all pizzas, which is called a _redirect_. Research how to make this happen in Sinatra.
* Your `edit` route will take users to a form, just like the `new` route. Only this time, the form should be pre-populated with the current data for the specific order we want to edit.
* Your `update` route will probably look pretty similar to the `create` route.
* Remember to add links where appropriate! These might be on the nav bar so they are always visible, or they might be on every item in the `index`, or might be on the `show` view... It's up to you!

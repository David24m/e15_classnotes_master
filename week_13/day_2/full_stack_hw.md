# Homework

Read over the code we did today. Don't be afraid to refer to it, but try not to copy / paste (except for config stuff like webpack).

### Make a very simple mongo database of your choosing.

- create a seed file (`use` a database `dropDatabase`, `insert` some documents)
- you can use `mongo < seed_data.js` (with `mongod` running in its own tab) to seed (and test) the database

### Serve up this data in an API.

- create a `server.js` with `express` with index and \<your resource\> `controllers` that use the express `Router`
- make a Query Helper. It should -
  - have functions to return the expected data (e.g. `all` returns all documents for that resource / collection)
  - these functions `connect` to the database `find` and convert `toArray` (via callbacks). Then run the callback provided in next step supplying the `docs` as an argument
- each route should use a Query Helper to get the necessary data from the database and provide a callback to the Query Helper that uses the `res` object to `send()` back JSON

### EXTENSION: If you feel ambitious, make a client / UI for your data
- write a XMLHttpRequest helper  - `client/helpers/requestHelper.js`
- Call your API request model from the file where you need the data - `client/app.js`
- Configure webpack to turn your 'source' code into `bundle.js` 
- Write the request to your own API on the back-end (using your requestHelper) and create DOM elements to display the reponse/s

---
### Notes
If you get this error message -    

`Unable to lock file: /data/db/mongod.lock Resource temporarily unavailable. Is a mongod instance already running?, terminating`

you probably didn't close mongod cleanly and you can quit `mongod` using Activity Monitor

---
If you get -   

`Error: listen EADDRINUSE :::3000`

You either have an express server running in another tab. Or the server did not quit properly - in which case use Activity Monitor to quit `node` 

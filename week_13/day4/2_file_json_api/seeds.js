use garden;

db.dropDatabase();

db.flowers.insert([
  {
    name: 'Rose',
    colour: 'Pink'
  },
  {
    name: 'Gardenia',
    colour: 'White'
  }
]);

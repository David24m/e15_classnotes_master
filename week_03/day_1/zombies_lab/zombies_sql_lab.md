# Zombies

Let's create a new database to model a zombie apocalypse. We want to keep track of which victims have been bitten by which zombies and when it happened. Looking at the description of what our DB will do, all the nouns indicate tables we'll need.

First make a new database in `psql` terminal: `CREATE DATABASE zombie_apocalpyse`

We'll need a `zombies` table and a `victims` table

Zombies will have
- a name
- a type
- an id

Victims will have
- name
- run speed
- id

Extension:
Think about how we might track the victims that a given zombie has bitten, and which zombies have bitten a given victim?

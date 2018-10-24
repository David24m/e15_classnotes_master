# Git Cheatsheet
---

## Creating and Cloning

- Creating a new reposoitory:
    - `git init` in the folder you want to be your repo.
- Cloning a repo from GitHub:
    - `git clone username@host:/path/copied/from/GitHub`

## Adding and removing

- Adding changes to the staging area to be 'saved' in the next commit:
    - `git add <filename>` for specific files.
    - `git add .` for all files and folders in the current folder.
- Removing changes from the staging area which have been `git add`'ed:
    - `git reset HEAD <filename>` for specific files.
    - `git reset HEAD .` for all files and folders in the current folder.

## Commiting and GitHub

- Committing changes that have been staged with `git add`:
    - `git commit -m "Short message describing changes."`
- Pushing changes to GitHub and setting the default (upstream) branch to push to:
    - `git push -u origin master`
- Pushing changes after you have set the upstream:
    - `git push`
- Getting changes from a GitHub repo down to your local copy:
    - `git pull`

## Getting information about your repo

- To see the current state of your repo; what changes are staged and unstaged, etc:
    - `git status`
- To see a list of all the commits you've made so far in the repo:
    - `git log`
# CZ2002 Assigment: Resturant Reservation and Point of Sale System (RRPSS)

CZ2002 Object-Oriented Design &amp; Programming Assignment (Console-Based Application)

# Setting up the Project

1. Install Maven on your system (https://maven.apache.org/download.cgi).

# Project Management

## General Guidelines

1. Format commit messages as per [suggested guide](https://www.theserverside.com/video/Follow-these-git-commit-message-guidelines)
2. Follow [directory layout of Maven](http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html). Maven is a build automation tool used primarily for Java projects.

## Workflow for New Features/ Fixes

1. On your PC ("locally"), switch to the master branch (`git checkout main`) and git pull to synchronize with the current main branch on GitHub (the "remote")

2. Create a new branch locally for the feature or bugfix. Feature branches should be named feat/name-of-feature and fixes should be named fix/name-of-fix. E.g., a feature to add checking of table availability could be implemented on a branch named feat/reservation-table-availability. In this case, the branch can be created and made your active branch by running git checkout -b feat/reservation-table-availability.

3. Implement your feature, committing regularly with any significant additions. E.g., one commit could add the relevant functions, the next commit could be to add tests, etc.

When you are done, git push your branch to GitHub.

Go to GitHub's Pull Requests page and create a pull request from your feature/fix branch to master.

Add a short description of what the pull request is trying to change.

Tag the appropriate people to review and approve the code you want to merge.

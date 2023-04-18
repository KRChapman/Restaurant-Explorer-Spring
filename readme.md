Live App: [Restaurant Exploring](https://restaurantexploring.com/)

### Search For google, yelp and health department restaurant data 

![my-store-search](https://github.com/KRChapman/Restaurant-Explorer/blob/master/src/assets/img/demo.gif)
# Contribution Guide

Project has two parts. This repository is the **back end** and the [front end](https://github.com/KRChapman/Restaurant-Explorer) is located [here](https://github.com/KRChapman/Restaurant-Explorer).

The backend is for calling Yelp and Health Department APis and for using a database to allow user to save searches.
The frontend in this repository handles the UI and Google Maps.

The project is based on [Material-Ui](https://material-ui.com/) and [React](https://reactjs.org/).


<details><summary>Reason for Separation</summary>
Full client side rendering  and a strict separation between the backend and the frontend.

Allow possible use of SSR and separate backend to reduce hosting costs and needed computing power. 

To swap or add different front end apps that use the backend api with a plan to add a mobile app, because the backend is already designed to handled decoupled front ends.

Independently deplorable. Separate repos most straight forward way to do the above even though a mono repo could acomplish this too.

Counter reason not to, because for most medium apps it is workable, but if application gets really large and you have a CI and CD pipeline with complex config often find a mono repo is better.


</details>

## API Keys



Sign up for free API keys then put them in a backend local file at the root for example .env.development.local and use the enviroment variable access them.

   ```javascript
      process.env.API_YELP 
      process.env.API_HEALTH;
   ```

[Yelp](https://www.yelp.com/developers)
<br />
[Health](https://dev.socrata.com/foundry/data.kingcounty.gov/f29f-zza5)
<br />
[Google Maps](https://developers.google.com/maps)
<br />

#### Google Maps

Google Maps does not need to be stored in enviroment variable a local file. Use it in the script tag located in public/index.html then control the api key access through the google console.

   ```javascript
     script" src="https://maps.googleapis.com/maps/api/js?key=APIKEY&libraries=places,drawing,geometry"></script>
   ```


## CORS

On the backend a cors package is used and the origin should be set up in a local variable file .env.development.local and point to local host example: FRONT_END_URL = http://localhost:3000

 ```javascript
  const cors = require('cors');

  const corsRoutes = {
    origin: `${process.env.FRONT_END_URL}`,
    optionsSuccessStatus: 200 // some legacy browsers (IE11, various SmartTVs) choke on 204
 }
  ```

## Serverless

The app is running serverless in production. To do this on the backend locally npm install will add the netlify cli in order to start localy and utilize serverless functions.

```javascript
 npm run dev
```

```
In the package.json
"dev": "netlify dev --functions=server --publish=dists/"
```

Then to call the backend and repective APIs localy add a file .env.local to the front end and.

```
REACT_APP_BASE = http://localhost:8888/.netlify/functions/index
```
Access URL

```javascript
const url = process.env.REACT_APP_BAS
 apiRequest(url, request)
```

## Setting Up The Development Environment

1. install node

  https://nodejs.org/en/

2. create a fork of this repository and then

    `git clone https://github.com/your-github-username/Restaurant-Explorer`

3. Set up git

      - `git remote add upstream https://github.com/KRChapman//Restaurant-Explorer`
      ```
        // make sure there are 2 remotes (origin that points to your fork and upstream for the original repo)
        git remote -v
      ```

    - **every time you start working on a new feature, run: `git pull upstream master` which ensures you are always working with the most updated version of the project.**

    - create a new branch `git checkout -b new-feature-name`


5. run the project

    ```javascript
    npm run server //for Restaurant-Explorer-Backend
    npm run start // For Restaurant-Explorer
    ```

6. make changes

7. run tests (`npm test` or `npm run test`)

8. if all the tests have passed, run

    ```
      git add .
      git commit -m 'description of what has changed'
      git push origin your_working_branch_name
    ```

9. go to github and create a new pull request from your fork (make sure it's against the -watch/master branch)

#### ** !if you encounter any errors related to sass-loader, run the following command! **

10. Follow same steps for both repositories.

<details><summary>Updating Node & npm</summary>

If you've tried the above, and things still aren't working you may need to update your version of node & npm. First, check your version of node by running `node -v`, and take note of it. 

To update node, install the package `n`, by running the command: `npm install -g n`. After the installation, run `n latest`. **note**: you may need to run `sudo n latest`, if on Mac or Linux.

Updating npm is quite simple, the command being: `npm install -g npm`. 

After updating the packages, close your current terminal and open a new one, so that the changes may take effect. Confirm the update by typing `node -v`.

</details>


---


### Writing Components

Our project is based on a library called [Material-Ui](https://material-ui.com/) 
That means that usually instead of writing plain html tags, you'll be able to just use one of the components provided by reactstrap.

for example, instead of writing a button element like this
```javascript
// plain html

<button className='primary'></button>
```

you can check on the documentation of Material-Ui if it provides a button component, and since it does, you can just use
```javascript
import Button from '@material-ui/core/Button';

const useStyles = makeStyles({"primary": "Red"}
const classes = useStyles();

<Button className={classes.primary} size="small"  variant="outlined">My Button</Button>


```

---


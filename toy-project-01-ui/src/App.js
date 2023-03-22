import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './static/css/sidebars.css';

import { BrowserRouter as Router, Switch, Route, NavLink, Link } from "react-router-dom";
import SideBar from './layouts/SideBar';
import routes from './routes';


function App() {
  return (
    <Router>
      <div className='d-flex'>
        <SideBar />
        <div className="container mt-5 px-5">
          <Switch>
            {routes.map(route => {
              return <Route exact key={route.key} path={route.path} component={route.component} />
            })}
          </Switch>
        </div>
      </div>
    </Router >
  );
}

export default App;

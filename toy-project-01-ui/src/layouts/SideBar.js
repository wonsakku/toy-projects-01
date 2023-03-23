import { NavLink, Link } from "react-router-dom";

const SideBar = () => {

    return (
        <div className="d-flex flex-column flex-shrink-0 p-3 text-bg-dark" style={{ width: "280px" }}>
            <a href="/" className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                <svg className="bi pe-none me-2" width="40" height="32"></svg>
                <span className="fs-4">Sidebar</span>
            </a>
            <hr />
            <ul className="nav nav-pills flex-column mb-auto">
                <li className="nav-item">
                    <Link className="nav-link text-white" to="/">Home</Link>
                </li>
                <li>
                    <Link className="nav-link text-white" to="/contents">Contents</Link>
                </li>
            </ul>
        </div>
    );
}

export default SideBar;
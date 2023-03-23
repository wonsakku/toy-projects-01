import Home from "./pages/Home";
import Contents from "./pages/Contents";
import ContentWrite from "./pages/ContentWrite";
import ContentEdit from "./pages/ContentEdit";


const routes = [
    {
        path: "/",
        component: Home,
        key: "sidebar-home"
    },
    {
        path: "/contents",
        component: Contents,
        key: "contents-list"
    },
    {
        path: "/contents/write",
        component: ContentWrite,
        key: "contents-write"
    },
    {
        path: "/contents/edit",
        component: ContentEdit,
        key: "contents-edit"
    }
];

export default routes;
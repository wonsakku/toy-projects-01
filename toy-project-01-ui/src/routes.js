import Home from "./pages/Home";
import Articles from "./pages/Articles";
import ArticleWrite from "./pages/ArticleWrite";
import ArticleEdit from "./pages/ArticleEdit";


const routes = [
    {
        path: "/",
        component: Home,
        key: "sidebar-home"
    },
    {
        path: "/articles",
        component: Articles,
        key: "sidebar-home"
    },
    {
        path: "/articles/write",
        component: ArticleWrite,
        key: "sidebar-home"
    },
    {
        path: "/articles/edit",
        component: ArticleEdit,
        key: "sidebar-home"
    }
];

export default routes;
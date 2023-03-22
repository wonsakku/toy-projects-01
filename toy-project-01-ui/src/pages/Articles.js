import axios from "axios";
import { useState, useEffect } from 'react';

const Articles = () => {

    const [articles, setArticles] = useState([]);

    const getArticles = () => {
        axios.get("http://localhost:8080/test")
            .then(res => {
                setArticles(res.data);
            });
    }

    useEffect(() => {
        getArticles();
    }, []);


    return (
        <div className="container row">
            {articles.map(article => {
                return (
                    <div className="col-12">
                        <div>순번 : {article.id}</div>
                        <div>이름 : {article.name}</div>
                        <div>나이 : {article.age}</div>
                    </div>
                );
            })}

        </div>
    );
}



export default Articles;

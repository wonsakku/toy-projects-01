import axios from "axios";
import { useState, useEffect } from 'react';
import Card from "../components/Card";
import { NavLink, Link } from "react-router-dom";


const Contents = () => {

    const [contents, setContents] = useState([]);

    const getContents = () => {
        axios.get("http://localhost:8080/contents")
            .then(res => {
                setContents(res.data);
            });
    }

    useEffect(() => {
        getContents();
    }, []);



    return (
        <>
            <header className="d-flex justify-content-between">
                <h3 className="mb-3">Contents</h3>
                <div className="px-5">
                    <Link className="btn btn-primary btn-sm" to="/contents/write">New</Link>
                </div>
            </header>
            <div className="container row">
                {contents.map(content => {
                    return (
                        <Card key={content.id}
                            reference={content.reference}
                            body={content.body}
                        />
                    );
                })}

            </div>
        </>
    );
}



export default Contents;

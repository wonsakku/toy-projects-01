import { useState, useEffect } from "react";
import axios from "axios";
import React from "react";
import { useHistory } from 'react-router-dom';


const ArticleWrite = () => {

    const [reference, setReference] = useState('');
    const [body, setBody] = useState('');
    const [classifications, setClassifications] = useState([]);
    const [selectedClassifications, setSelectedClassifications] = useState([]);
    const [classificationIds, setClassificationIds] = useState([]);
    const history = useHistory();

    const getClassifications = () => {
        axios.get("http://localhost:8080/classifications/select-box")
            .then(res => setClassifications(res.data));
    }

    const Option = ({ value, name }) => {
        return (
            <option value={value}>{name}</option>
        );
    }


    const substract = (target) => {
        const targetValue = target.value;
        console.log(selectedClassifications);
        let targetIndex = 0;
        for (let i = 0; i < selectedClassifications.length; i++) {
            if (selectedClassifications[i].props.value == targetValue) {
                targetIndex = i;
                break;
            }
        }

        if (selectedClassifications[targetIndex].props.value == targetValue) {
            selectedClassifications.splice(targetIndex, 1);
            setSelectedClassifications(selectedClassifications);
            setClassificationIds(classificationIds.filter(classification => targetValue != classification));
        }
    }


    const addClassification = (e) => {
        const selected = document.querySelector("#classification-selectbox option:checked");
        if (!selected.value) {
            alert("항목을 선택해주세요");
            return;
        }

        const correspondCount = classificationIds.filter(insertClassification => selected.value == insertClassification).length;
        if (correspondCount > 0) {
            alert("선택한 항목입니다.");
            return;
        }

        const element = React.createElement("button",
            {
                className: "btn btn-secondary btn-sm me-2",
                type: "button",
                value: `${selected.value}`,
                children: `${selected.innerHTML}`,
                key: `${selected.value}`,
                onClick: (e) => {
                    substract(e.target)
                }
            }
        );

        selectedClassifications.push(element);
        setSelectedClassifications(selectedClassifications);
        setClassificationIds([...classificationIds, selected.value]);
    }

    function onSubmit() {
        if (!window.confirm("저장하시겠습니까?")) {
            return;
        }
        console.log(classificationIds);
        axios.post("http://localhost:8080/contents", {
            reference, body, classificationIds
        }).then(() => { history.push("/contents") });
    }



    useEffect(() => {
        getClassifications();
    }, []);


    return (
        <div className="container">
            <header>
                <h1>ArticleWrite</h1>
            </header>
            <div className="mt-5">
                <form>
                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Reference</label>
                        <input type="text" className="form-control" id="reference" onChange={(e) => setReference(e.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="exampleInputPassword1" className="form-label">Body</label>
                        <textarea className="form-control" id="body" rows="20" onChange={(e) => setBody(e.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Classfications</label>
                        <div className="row">
                            <div className="col-8" id="classification-group">
                                {selectedClassifications}
                            </div>
                            <div className="col-3">
                                <select className="form-select" id="classification-selectbox">
                                    <option value="">=== 선택 ===</option>
                                    {classifications.map(classification => {
                                        return <Option value={classification.id} key={classification.id} name={classification.name}></Option>
                                    })}
                                </select>
                            </div>
                            <div className="col-1">
                                <button type="button" className="btn btn-primary" onClick={addClassification}>Add</button>
                            </div>
                        </div>
                    </div>
                    <hr />
                    <div className="mt-3 py-3">
                        <button type="button" className="btn btn-success" onClick={onSubmit}>Submit</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default ArticleWrite;

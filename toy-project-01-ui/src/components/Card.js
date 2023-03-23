const Card = ({ contentId, reference, body, classifications }) => {

    return (

        <div className="card" style={{ width: "33%" }}>
            <img src="..." className="card-img-top" alt="..." />
            <div className="card-body">
                {/* <h5 className="card-title">{reference}</h5> */}
                <p className="card-text">{body}</p>
            </div>
            <ul className="list-group list-group-flush">
                <li className="list-group-item">{reference}</li>
                <li className="list-group-item">
                    <div>
                        {classifications.map((classification) => {
                            return (
                                <button key={`${contentId}_${classification.id}`} className="btn btn-secondary btn-sm mx-1" value={classification.id}>{classification.name}</button>
                            );
                        })}
                    </div>
                </li>
                {/* <li className="list-group-item">A third item</li> */}
            </ul>
            {/* <div className="card-body">
                <a href="#" className="card-link">Card link</a>
                <a href="#" className="card-link">Another link</a>
            </div> */}
        </div>
    );
}

export default Card;
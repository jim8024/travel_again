import React from 'react';
import './TourModal.css';
import PersonIcon from '@mui/icons-material/Person';
import FavoriteIcon from '@mui/icons-material/Favorite';
import BookmarkIcon from '@mui/icons-material/Bookmark';
import CloseIcon from '@mui/icons-material/Close';
import tourjson from '../../utils/finalresult.json';

const TourModal = ({ isOpen, onClose, contentid }) => {
    if (!isOpen) return null;
    const tourData = tourjson.find((item) => item.contentid === contentid);
    console.log(tourData);
    return (
        <div className="tour-modal-overlay">
            <div className="tour-modal">
                <div className="tour-modal-header">
                    <button className="tour-modal-close" onClick={onClose}>
                        <CloseIcon />
                    </button>
                </div>
                <div className="tour-modal-grid">
                    <div className="tour-modal-text">
                        <h1 style={{ marginTop: '0px' }}>{tourData.title}</h1>
                        <h3>{tourData.addr1}</h3>
                        <p>{tourData.overview}</p>
                        <div className="tour-modal-icon">
                            <PersonIcon sx={{ fontSize: 45 }} />
                            <FavoriteIcon sx={{ fontSize: 45 }} />
                            <BookmarkIcon sx={{ fontSize: 45 }} />
                        </div>
                    </div>
                    <div className="tour-modal-image">
                        <img src={tourData.firstimage} alt={tourData.title} />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default TourModal;

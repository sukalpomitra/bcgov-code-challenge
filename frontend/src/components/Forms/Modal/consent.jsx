import React, { useState } from 'react'
import { Button, Modal } from 'react-bootstrap'
function ConsentModal(props) {
    const { showModal, handleClose, onAcceptConsent } = props
    const [isChecked, setIsChecked] = useState(false);
    const handleCheckboxChange = () => {
        setIsChecked(!isChecked);
    };
    return (
        <Modal show={showModal} onHide={handleClose} centered backdrop="static" keyboard={false} className="modal-lg">
            <Modal.Body>
                {/* Add a card with a primary button in the middle */}
                <div className="text-center">
                    <div className="card-body">
                        <p>
                            {`Do you agree to provide your private details to this site?`}
                        </p>
                        <label>
                            <input
                                type="checkbox"
                                checked={isChecked}
                                onChange={handleCheckboxChange}
                            />{' '}
                            I agree to share details
                        </label>
                        <Modal.Footer>
                            <Button disabled={!isChecked} variant="primary" onClick={onAcceptConsent} className='modal_btn'>
                                Agree
                            </Button>
                            <Button variant="danger" onClick={handleClose} className='modal_btn'>
                                Disagree
                            </Button>
                        </Modal.Footer>

                    </div>
                </div>
            </Modal.Body>
        </Modal>
    )
}

export default ConsentModal
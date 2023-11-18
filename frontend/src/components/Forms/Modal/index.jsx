import React from 'react'
import { Button, Modal } from 'react-bootstrap'

import '../Styles/modalStyles.css'

import clap from 'assets/clap.gif'

function ConfirmationModal(props) {

    const { showModal, handleClose } = props

    return (
        <Modal show={showModal} onHide={handleClose} centered backdrop="static" keyboard={false} className="modal-lg">
            <Modal.Body>
                {/* Add a card with a primary button in the middle */}
                <div className="text-center">
                    <div className="card-body">
                        <img src={clap} alt="GIF" style={{ maxWidth: "100%", maxHeight: "150px", padding: "2vh" }} />
                        <h5 className="card-title">Thank you for your willingness to volunteer!</h5>
                        <p className="card-text">We appreciate your commitment to making a difference. Your application to join our disaster response volunteer team has been successfully submitted.</p>

                        {/* Primary button in the middle */}
                        <Button variant="primary" onClick={handleClose} className='modal_btn'>
                            Back to home
                        </Button>
                    </div>
                </div>
            </Modal.Body>
        </Modal>
    )
}

export default ConfirmationModal
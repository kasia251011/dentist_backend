import express from 'express';
import { addAppointment, deleteAppointment, getAllAppointments, getAppointment, getAppointmentsByPatient } from '../controller/Appointment';

const router = express.Router()

router.post('', addAppointment)
router.get('', getAllAppointments)
router.get('/:id', getAppointment)
router.get('/:patintId', getAppointmentsByPatient)
router.delete('/:id', deleteAppointment)

export default router;
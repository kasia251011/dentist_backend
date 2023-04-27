import express from 'express';
import { addAppointment, deleteAppointment, getAppointmentsByDate, getAppointmentsByPatient } from '../controller/Appointment';

const router = express.Router()

router.post('', addAppointment)
router.get('', getAppointmentsByDate)
router.get('', getAppointmentsByPatient)
router.delete('/:id', deleteAppointment)

export default router;
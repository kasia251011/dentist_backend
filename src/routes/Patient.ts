import express from 'express';
import { 
  addPatient, 
  deletePatient, 
  getAllPatients, 
  getPatient, 
  pushToothHistory 
} from '../controller/Patient';

const router = express.Router()

router.post('', addPatient)
router.get('', getAllPatients)
router.get('/:id', getPatient)
router.delete('/:id', deletePatient)
router.patch('/:patientId/teeth/:toothId', pushToothHistory)

export default router;
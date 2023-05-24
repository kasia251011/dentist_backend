import express from 'express';
import { 
  addPatient, 
  deletePatient, 
  getAllPatients, 
  getPatient, 
  getPatientDiagnosisTooth, 
  getPatientTeeth, 
  pushToothDiagnosisByToothNo,
  updateTooth
} from '../controller/Patient';
import multer from 'multer';

const router = express.Router()

router.post('', addPatient)
router.get('', getAllPatients)
router.get('/:id', getPatient)
router.get('/:id/teeth', getPatientTeeth)
router.get('/:patientId/teeth/:toothNo/:index', getPatientDiagnosisTooth)
router.delete('/:id', deletePatient)
router.patch('/:patientId/teeth/:toothNo', pushToothDiagnosisByToothNo)
router.put('/:patientId/teeth/:toothNo', updateTooth);

export default router;
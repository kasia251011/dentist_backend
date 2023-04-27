import express from 'express';
import { 
  addPatient, 
  deletePatient, 
  getAllPatients, 
  getPatient,
  getPatientTeeth, 
  pushToothDiagnosisByToothNo
} from '../controller/Patient';
import multer from 'multer';

const router = express.Router()

router.post('', addPatient)
router.get('', getAllPatients)
router.get('/:id', getPatient)
router.get('/:id/teeth', getPatientTeeth)
// router.get('/:diagnosisId', getPatientDiagnosisTooth)
router.delete('/:id', deletePatient)
router.patch('/:patientId/teeth/:toothNo', pushToothDiagnosisByToothNo)

export default router;
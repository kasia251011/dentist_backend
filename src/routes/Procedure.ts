import express from 'express';
import { addProcedure, deleteProcedure, getAllProcedures, getProcedure } from '../controller/Procedure';

const router = express.Router()

router.post('', addProcedure)
router.get('', getAllProcedures)
router.get('/:id', getProcedure)
router.delete('/:id', deleteProcedure)

export default router;
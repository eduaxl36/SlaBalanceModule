Attribute VB_Name = "Módulo7"
Sub NM_INST()
Attribute NM_INST.VB_ProcData.VB_Invoke_Func = " \n14"
'
' NM_INST Macro
'

'
    Rows("13:24").Select
    Selection.Delete Shift:=xlUp
    Range("B13").Select
    ActiveCell.FormulaR1C1 = "T15"
    Range("B14").Select
    ActiveCell.FormulaR1C1 = "T35"
    Range("B15").Select
    ActiveCell.FormulaR1C1 = "T50"
    Range("B13").Select
    ActiveCell.FormulaR1C1 = "D15"
    Range("B14").Select
    ActiveCell.FormulaR1C1 = "D35"
    Range("B15").Select
    ActiveCell.FormulaR1C1 = "D50"
    Range("B16").Select
    ActiveCell.FormulaR1C1 = "T1"
    Range("B17").Select
    ActiveCell.FormulaR1C1 = "T3"
    Range("B18").Select
    ActiveCell.FormulaR1C1 = "T5"
    Range("B19").Select
End Sub

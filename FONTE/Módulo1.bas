Attribute VB_Name = "Módulo1"
Sub Normalizar_Plan()
Attribute Normalizar_Plan.VB_ProcData.VB_Invoke_Func = " \n14"
'
' Normalizar_Plan Macro
'

'
    Sheets(Array("CAM", "GOI", "BHZ", "GRJ", "GSP", "DFE", "CTA", "FLO", "POA", "FOR", "REC", _
        "SAL", "GBE", "MAN", "GVI", "PNT")).Select
    Sheets("CAM").Activate
    ActiveCell.Cells.Select
    ActiveCell.Offset(29, -23).Range("A1").Activate
    ActiveWindow.LargeScroll Down:=-1
    Selection.Copy
    ActiveCell.Offset(-30, 0).Range("A1:B2").Select
    Selection.PasteSpecial Paste:=xlPasteValues, Operation:=xlNone, SkipBlanks _
        :=False, Transpose:=False
    ActiveCell.Range("A1:B2").Select
    Application.CutCopyMode = False
    ActiveWorkbook.Save
End Sub

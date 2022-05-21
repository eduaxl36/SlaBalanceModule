Attribute VB_Name = "Módulo6"
Sub INSTALADOS()
Attribute INSTALADOS.VB_ProcData.VB_Invoke_Func = " \n14"
'
' INSTALADOS Macro
'

'
    Range("B5").Select
    Sheets(Array("CAM", "GOI", "BHZ", "GRJ", "GSP", "DFE", "CTA", "FLO", "POA", "FOR", "REC", _
        "SAL", "GBE", "MAN", "GVI", "PNT")).Select
    Sheets("CAM").Activate
    ActiveWindow.SmallScroll Down:=-18
    Rows("37:237").Select
    Selection.Delete Shift:=xlUp
    ActiveWindow.SmallScroll Down:=-21
    Rows("13:24").Select
    Selection.Delete Shift:=xlUp
    Range("B16").Select
    ActiveCell.FormulaR1C1 = "T1"
    Range("B17").Select
    ActiveCell.FormulaR1C1 = "T3"
    Range("B18").Select
    ActiveCell.FormulaR1C1 = "T5"
    Range("B13").Select
    ActiveCell.FormulaR1C1 = "I15"
    Range("B14").Select
    ActiveCell.FormulaR1C1 = "I35"
    Range("B15").Select
    ActiveCell.FormulaR1C1 = "I50"
    Range("B11").Select
    ActiveCell.FormulaR1C1 = "TC"
    Range("B12").Select
    ActiveCell.FormulaR1C1 = "NTC"
    Range("B9").Select
    ActiveCell.FormulaR1C1 = "CABT"
    Range("B10").Select
    ActiveCell.FormulaR1C1 = "CABNT"
    Range("B5").Select
    ActiveCell.FormulaR1C1 = "AB"
    Range("B8").Select
    ActiveCell.FormulaR1C1 = "DE"
    Range("B5").Select
    ActiveCell.FormulaR1C1 = ";"
    Range("A4:B4").Select
    With Selection
        .HorizontalAlignment = xlGeneral
        .VerticalAlignment = xlBottom
        .WrapText = False
        .Orientation = 0
        .AddIndent = False
        .IndentLevel = 0
        .ShrinkToFit = False
        .ReadingOrder = xlContext
    End With
    Selection.UnMerge
    Range("A4").Select
    Selection.Copy
    Range("B4").Select
    ActiveSheet.Paste
    Range("A4").Select
    Application.CutCopyMode = False
    Selection.ClearContents
    Range("A4:A34").Select
    ActiveWindow.SmallScroll Down:=-45
    Columns("A:A").Select
    Range("A3").Activate
    Selection.Delete Shift:=xlToLeft
    Cells.Select
    Selection.Copy
    Range("A1:A2").Select
    Selection.PasteSpecial Paste:=xlPasteValues, Operation:=xlNone, SkipBlanks _
        :=False, Transpose:=False
    Columns("AH:AX").Select
    Range("AH2").Activate
    Application.CutCopyMode = False
    Selection.Delete Shift:=xlToLeft
    ActiveWindow.SmallScroll ToRight:=-26
    Range("A4").Select
    ActiveWorkbook.Save
    ChDir "C:\Users\eduax\Desktop\Projetos\BalanceColect\FONTE"
    ActiveWorkbook.SaveAs Filename:= _
        "C:\Users\eduax\Desktop\Projetos\BalanceColect\FONTE\MC_INSTALADO.xlsm", _
        FileFormat:=xlOpenXMLWorkbookMacroEnabled, CreateBackup:=False
End Sub

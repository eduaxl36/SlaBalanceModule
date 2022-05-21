Attribute VB_Name = "Módulo8"
Sub OF_MC()
Attribute OF_MC.VB_ProcData.VB_Invoke_Func = " \n14"
'
' OF_MC Macro
'

'
    Sheets(Array("CAM", "GOI", "BHZ", "GRJ", "GSP", "DFE", "CTA", "FLO", "POA", "FOR", "REC", _
        "SAL", "GBE", "MAN", "GVI", "PNT")).Select
    Sheets("CAM").Activate
    ActiveWindow.SmallScroll Down:=-69
    Sheets(Array("CAM", "GOI", "BHZ", "GRJ", "GSP", "DFE", "CTA", "FLO", "POA", "FOR", "REC", _
        "SAL", "GBE", "MAN", "GVI", "PNT")).Select
    Sheets("CAM").Activate
    Range("B5").Select
    ActiveCell.FormulaR1C1 = "AB"
    Range("B8").Select
    ActiveCell.FormulaR1C1 = "DE"
    Range("B9").Select
    ActiveCell.FormulaR1C1 = "CABT"
    Range("B10").Select
    ActiveCell.FormulaR1C1 = "CABNT"
    Range("B11").Select
    ActiveCell.FormulaR1C1 = "CRT"
    Range("B12").Select
    ActiveCell.FormulaR1C1 = "CRNT"
    Rows("13:24").Select
    Selection.Delete Shift:=xlUp
    Range("B13").Select
    ActiveCell.FormulaR1C1 = "I15"
    Range("B14").Select
    ActiveCell.FormulaR1C1 = "I35"
    Range("B15").Select
    ActiveCell.FormulaR1C1 = "I50"
    Range("B16").Select
    ActiveCell.FormulaR1C1 = "T1"
    Range("B17").Select
    ActiveCell.FormulaR1C1 = "T3"
    Range("B18").Select
    ActiveCell.FormulaR1C1 = "T5"
    Rows("19:20").Select
    Selection.Delete Shift:=xlUp
    Range("B19").Select
    ActiveCell.FormulaR1C1 = "TV1"
    Range("B20").Select
    ActiveCell.FormulaR1C1 = "TV2"
    Rows("21:22").Select
    Selection.Delete Shift:=xlUp
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
    ActiveCell.FormulaR1C1 = "VAR"
    Range("B4").Select
    ActiveCell.FormulaR1C1 = "BL"
    Rows("21:125").Select
    Selection.Delete Shift:=xlUp
    ActiveWindow.SmallScroll Down:=-21
    Range("A9").Select
    ActiveCell.FormulaR1C1 = "CABLE"
    Range("A10").Select
    ActiveCell.FormulaR1C1 = "CABLE"
    Range("A11").Select
    ActiveCell.FormulaR1C1 = "Crianças"
    Range("A11").Select
    ActiveCell.FormulaR1C1 = "Crianças"
    Range("A11").Select
    ActiveCell.FormulaR1C1 = "CR"
    Range("A12").Select
    ActiveCell.FormulaR1C1 = "CR"
    Range("A13").Select
    ActiveCell.FormulaR1C1 = "IDADE"
    Range("A14").Select
    ActiveCell.FormulaR1C1 = "IDADE"
    Range("A15").Select
    ActiveCell.FormulaR1C1 = "IDADE"
    Range("A16").Select
    ActiveCell.FormulaR1C1 = "FAM"
    Range("A17").Select
    ActiveCell.FormulaR1C1 = "FAM"
    Range("A18").Select
    ActiveCell.FormulaR1C1 = "FAM"
    Range("A19").Select
    ActiveCell.FormulaR1C1 = "TV"
    Range("A20").Select
    ActiveCell.FormulaR1C1 = "TV"
    Cells.Select
    Selection.Copy
    Range("A1:B2").Select
    Selection.PasteSpecial Paste:=xlPasteValues, Operation:=xlNone, SkipBlanks _
        :=False, Transpose:=False
    Sheets("PNT").Select
    Application.CutCopyMode = False
    ActiveWorkbook.Save
    Sheets("CAM").Select
    ChDir "C:\Users\eduax\Desktop\Projetos\BalanceColect\FONTE"

End Sub

Attribute VB_Name = "Módulo3"
Sub MC_NORMALIZADOR()
Attribute MC_NORMALIZADOR.VB_ProcData.VB_Invoke_Func = " \n14"
'
' MC_NORMALIZADOR Macro
'

'
    Sheets(Array("CAM", "GOI", "BHZ", "GRJ", "GSP", "DFE", "CTA", "FLO", "POA", "FOR", "REC", _
        "SAL", "GBE", "MAN", "GVI", "PNT")).Select
    Sheets("CAM").Activate
    ActiveWindow.SmallScroll Down:=-45
    Range("A4:B4").Select
    Selection.Copy
    Application.CutCopyMode = False
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
    Range("B5").Select
    ActiveCell.FormulaR1C1 = "AB"
    Rows("13:24").Select
    Selection.Delete Shift:=xlUp
    Range("A16").Select
    ActiveCell.FormulaR1C1 = "TamFamília"
    Range("A16").Select
    Columns("A:A").EntireColumn.AutoFit
    Range("A16").Select
    Selection.Copy
    Range("A17").Select
    ActiveSheet.Paste
    Range("A18").Select
    ActiveSheet.Paste
    Rows("19:20").Select
    Application.CutCopyMode = False
    Selection.Delete Shift:=xlUp
    Range("A19:A20").Select
    With Selection
        .HorizontalAlignment = xlCenter
        .VerticalAlignment = xlCenter
        .WrapText = False
        .Orientation = 0
        .AddIndent = False
        .IndentLevel = 0
        .ShrinkToFit = False
        .ReadingOrder = xlContext
        .MergeCells = False
    End With
    Range("A19").Select
    ActiveCell.FormulaR1C1 = "tv"
    Range("A20").Select
    ActiveCell.FormulaR1C1 = "TV"
    Range("A19").Select
    ActiveCell.FormulaR1C1 = "TV"
    Range("A13").Select
    ActiveCell.FormulaR1C1 = "IDADE"
    Range("A4:A22").Select
    Selection.EntireColumn.Delete
    Cells.Select
    Selection.Copy
    Range("A1:A2").Select
    Selection.PasteSpecial Paste:=xlPasteValues, Operation:=xlNone, SkipBlanks _
        :=False, Transpose:=False
    Range("A1:A2").Select
End Sub

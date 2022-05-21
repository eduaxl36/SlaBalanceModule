Attribute VB_Name = "Módulo2"
Sub NORMALIZADOR()
Attribute NORMALIZADOR.VB_ProcData.VB_Invoke_Func = " \n14"
'
' NORMALIZADOR Macro
'

'
    Sheets(Array("CAM", "GOI", "BHZ", "GRJ", "GSP", "DFE", "CTA", "FLO", "POA", "FOR", "REC", _
        "SAL", "GBE", "MAN", "GVI", "PNT")).Select
    Sheets("CAM").Activate
    ActiveWindow.SmallScroll Down:=-42
    Cells.Select
    Selection.Copy
    Range("A1:B2").Select
    Selection.PasteSpecial Paste:=xlPasteValues, Operation:=xlNone, SkipBlanks _
        :=False, Transpose:=False
    Range("A4:B4").Select
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
    Selection.Cut
    Range("B4").Select
    ActiveSheet.Paste
    Columns("B:B").EntireColumn.AutoFit
    Range("C4").Select
    ActiveCell.FormulaR1C1 = "1"
    Range("D4").Select
    Selection.Copy
    Range("C4").Select
    Selection.PasteSpecial Paste:=xlPasteFormats, Operation:=xlNone, _
        SkipBlanks:=False, Transpose:=False
    Application.CutCopyMode = False
    Range("A1:B2").Select
End Sub

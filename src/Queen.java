public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }
    public String getColor() {
        return color;
    }
    public String getSymbol(){
        return "Q";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        int deltaLine = Integer.signum(toLine - line);
        int deltaColumn = Integer.signum(toColumn - column);
        int currentLine = line + deltaLine;
        int currentColumn = column + deltaColumn;
//Checking Diagonal Movements
        while (currentLine != toLine && currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += deltaLine;
            currentColumn += deltaColumn;
        }

//Checking for horizontal movement
        if (line == toLine) {
            while (currentColumn != toColumn) {
                if (chessBoard.board[line][currentColumn] != null) {
                    return false;
                }
                currentColumn += deltaColumn;
            }
        }
        // Check for vertical movement
        else if (column == toColumn) {
            while (currentLine != toLine) {
                if (chessBoard.board[currentLine][column] != null) {
                    return false;
                }
                currentLine += deltaLine;
            }
        }




        if (toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7 ) {
            if( (Math.abs(line - toLine) == (Math.abs(column - toColumn))) &&
                    (line != toLine || column != toColumn)||
            (line == toLine) && (column != toColumn) || (line != toLine) && (column == toColumn)){
//                check=false;
                return true;
            }
            }
        return false;
    }
}


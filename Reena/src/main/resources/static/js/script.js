// scripts.js
document.addEventListener("DOMContentLoaded", function() {
    // Activate tooltips
    $('[data-toggle="tooltip"]').tooltip();

    // Event listener for table row clicks
    document.querySelectorAll('.table tbody tr').forEach(function(row) {
        row.addEventListener('click', function() {
            const cells = row.querySelectorAll('td');
            let rowData = {};
            cells.forEach((cell, index) => {
                rowData[`col${index}`] = cell.textContent;
            });
            console.log('Row data:', rowData);
            alert(`Row clicked:\n${JSON.stringify(rowData, null, 2)}`);
        });
    });
});

// Function to add a new row to the table
function addTableRow(tableId, rowData) {
    const table = document.getElementById(tableId);
    const tbody = table.querySelector('tbody');
    const newRow = tbody.insertRow();
    
    rowData.forEach(data => {
        const newCell = newRow.insertCell();
        newCell.textContent = data;
    });

    newRow.addEventListener('click', function() {
        let rowData = {};
        newRow.querySelectorAll('td').forEach((cell, index) => {
            rowData[`col${index}`] = cell.textContent;
        });
        console.log('Row data:', rowData);
        alert(`Row clicked:\n${JSON.stringify(rowData, null, 2)}`);
    });
}

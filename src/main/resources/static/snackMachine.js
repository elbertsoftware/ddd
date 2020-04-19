const rootUri = 'http://localhost:8080/snackmachine/1';

let getSnackMachine = () => {
    $.get(rootUri, (data, status) => {
        let amount = data.transactionCentCount * 0.01 + 
                     data.transactionDimeCount * 0.10 +
                     data.transactionQuarterCount * 0.25 +
                     data.transactionDollarCount +
                     data.transactionFiveDollarCount * 5. +
                     data.transactionTwentyDollarCount * 20.;
        $('#moneyInserted').html(amount);
        $('#cent').html(data.centCount);
        $('#dime').html(data.dimeCount);
        $('#quarter').html(data.quarterCount);
        $('#dollar').html(data.dollarCount);
        $('#fiveDollar').html(data.fiveDollarCount);
        $('#twentyDollar').html(data.twentyDollarCount);
    })
};

let insertMoney = (money) => {
    $.ajax({
        url: rootUri + '/moneyInTransaction/' + money,
        type: 'PUT',
        success: (result) => {
            // do something with the result
        }
    });

    location.reload();
};

let returnMoney = () => {
    $.ajax({
        url: rootUri + '/moneyInTransaction',
        type: 'PUT',
        success: (result) => {
            // do something with the result
        }
    });

    location.reload();
};

let buySnack = (slotNumber) => {
    $.ajax({
        url: rootUri + '/' + slotNumber,
        type: 'PUT',
        success: (result) => {
            // do something with the result
        }
    });

    location.reload();
};

getSnackMachine();

$('button').click((event) => {
    switch (event.currentTarget.id) {
    case 'btnInsertCent':
        insertMoney('Cent');
        break;
    case 'btnInsertDime':
        insertMoney('Dime');
        break;
    case 'btnInsertQuarter':
        insertMoney('Quarter');
        break;
    case 'btnInsertDollar':
        insertMoney('Dollar');
        break;
    case 'btnInsertFiveDollar':
        insertMoney('FiveDollar');
        break;
    case 'btnInsertTwentyDollar':
        insertMoney('TwentyDollar');
        break;
    case 'btnReturnMoney':
        returnMoney();
        break;
    case 'btnBuy':
        buySnack(1);
        break;
    default:
        break;
    }
});
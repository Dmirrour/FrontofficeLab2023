function handleComplete(xhr, status, args) {
    if (args && args.message) {
        // Mostrar el mensaje en el growl
        PF('msg').show([{severity:'info', summary: '', detail: args.message}]);
    }
}
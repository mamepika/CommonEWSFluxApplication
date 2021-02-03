function loadComments () {

    this.source = null;

    this.start = function () {

        var dataTable = document.getElementById("items");

        this.source = new EventSource("/feed");

        this.source.addEventListener("message", function (event) {

            // These events are JSON, so parsing and DOM fiddling are needed
            var item = JSON.parse(event.data);

            var row = commentTable.getElementsByTagName("tbody")[0].insertRow(0);
            var cell0 = row.insertCell(0);
            var cell1 = row.insertCell(1);
            var cell2 = row.insertCell(2);

            cell0.className = "author-style";
            cell0.innerHTML = item.preamble;

            cell1.className = "text";
            cell1.innerHTML = item.mt;

            cell2.className = "date";
            cell2.innerHTML = item.messageType;

        });

        this.source.onerror = function () {
            this.close();
        };

    };

    this.stop = function() {
        this.source.close();
    }

}

comment = new loadComments();

/*
 * Register callbacks for starting and stopping the SSE controller.
 */
window.onload = function() {
    comment.start();
};
window.onbeforeunload = function() {
    comment.stop();
}
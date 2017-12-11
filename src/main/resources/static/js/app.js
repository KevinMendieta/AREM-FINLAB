//@author KevinMendieta

const Module = (function() {

	const putLogs = function(logs) {
		logs.forEach((log) => {
			const content = "<tr><td class=" + '"myTd">' + log + "</td></tr>";
			$('#myTable tbody').append(content);
		});
	}

	return {
		init : function() {
			$.get("/logs", putLogs);
		}
	};

})();
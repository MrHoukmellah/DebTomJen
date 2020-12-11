<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page import="com.simulationcredit.model.Model" %>
<jsp:include page = "Header.jsp"/>

<!-- Nav tabs -->
<ul class="nav nav-tabs" id="parentTab" role="tablist">

	<c:forEach var="model" items = "${modelList}" varStatus = "loop">
	  <!--<c:set var = "hrefList" value = "#nav-${ model.getBanque().getNom() }"></c:set>-->
	  <li class="nav-item">
	    <a class="nav-link" id="nav-${loop.index}-tab" data-toggle="tab" href="#nav-${loop.index}" role="tab" aria-controls="${loop.index}" aria-selected="true">${ model.getBanque().getNom() }</a>
	  </li>
	</c:forEach>    
	
</ul>
<div class="tab-content" id="nav-tabContent">
	<c:forEach var="model" items = "${modelList}" varStatus ="loop">
		<div class="tab-pane fade " id="nav-${loop.index}" role="tabpanel" aria-labelledby="nav-${fn:replace(model.getBanque().getNom(),' ','')}-tab">
			<ul class="nav nav-tabs" id="childTab-${loop.index}" role="tablist">
 				<c:forEach var = "typesCredits" items = "${model.getBanque().getTypesCredits()}" varStatus = "secondLoop">
		 		  <li class="nav-item">
				    <a class="nav-link type-credits" id="nav-${loop.index}-${secondLoop.index}-tab" data-toggle="tab" href="#nav-${loop.index}-${secondLoop.index}" role="tab" aria-controls="${loop.index}-${secondLoop.index}" aria-selected="true">${typesCredits.getNomCredit()}</a>
				  </li>
 				</c:forEach>
			</ul>
		</div>
	</c:forEach>    
</div>
<c:forEach var="model" items = "${modelList}" varStatus = "loop">
	<div class="tab-content" id="nav-tabContent">
		<c:forEach var = "typesCredits" items = "${model.getBanque().getTypesCredits()}" varStatus = "secondLoop">
			<div class="tab-pane fade childs" id="nav-${loop.index}-${secondLoop.index}" role="tabpanel" aria-labelledby="nav-${loop.index}-${secondLoop.index}-tab">
				<p>${typesCredits.getNomCredit()}-${model.getBanque().getNom()}-${ typesCredits.getLimiteMois()[0] }-${ typesCredits.getLimiteMois()[1] }</p>
				<form>
  					<div class="form-row">
 						<div class="col-md-12 mb-3">
							<label for="customRange3">Mois</label>
							<input type="range" name="monthDuration" class="custom-range" min="${ typesCredits.getLimiteMois()[0] }" max="${ typesCredits.getLimiteMois()[1] }" step="1" id="customRange3">
							<span id ="slider_value"></span>
						</div>
						<div class="col-md-12 mb-3">
							<label for="customRange3">Montant</label>
							<input type="range" name="amountCredit" class="custom-range" min="${ typesCredits.getLimiteCredit()[0] }" max="${ typesCredits.getLimiteCredit()[1] }" step="1000" id="customRange3">
							<span id ="slider_value"></span>
						</div>
						<div class="col-md-12 mb-3">
							<label for="taux">Taux du crédit</label>
							<input type="text" name="rate" readonly class="custom-control-plaintext" id="tauxValue" value="${typesCredits.getTaux() }" style="width:25%">							
						</div>
					</div>
					<input type="hidden" name="properties" value="${ typesCredits.getPropertiesString() }">			
					<button class="btn btn-primary submit" type="submit">Submit form</button>
					<div id="ajaxResponse"></div>
				</form>
			</div>	
		</c:forEach>
	</div>
</c:forEach>

<jsp:include page = "Footer.jsp"/>
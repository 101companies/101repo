using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using csharpBaseline;

namespace csharpAspNetMvc.Controllers
{
    public class CompanyController : Controller
    {
        //
        // GET: /Company/

        public ActionResult Index()
        {
            return View(CompanyRepository.CreateInMemoryModel());
        }
    }
}

package com.nesth2o.watersystem

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_user_agreement.*

class UserAgreementActivity : AppCompatActivity() {

    val EULA_HTML_TEXT = "file:///android_asset/raw/eula.html"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_agreement)

        val webSettings = webView.settings
        //webSettings.javaScriptEnabled = true
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true)
        //if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            webSettings.setAllowFileAccessFromFileURLs(true)
            webSettings.setAllowUniversalAccessFromFileURLs(true)
        //}
        //webView.loadUrl(EULA_HTML_TEXT)
        val htmlFile = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Please read and click the accept button at the bottom.</title>\n" +
                "</head>\n" +
                "<body bgcolor=\"#E6E6FA\">\n" +
                "<font face=\"sans-serif\">\n" +
                "\n" +
                "    <p><b>TERMS AND CONDITIONS FOR WATER MANAGEMENT SYSTEM SOFTWARE USERS</b></p>\n" +
                "    <p>These terms and conditions (\"Terms\") govern your use of the WATER MANAGEMENT SYSTEM SOFTWARE\n" +
                "        web application (\"Service\") offered by Schlage Lock Company, LLC (\"Company\"). Additional\n" +
                "        terms and conditions that apply to the WATER MANAGEMENT SYSTEM SOFTWARE software\n" +
                "        (\"Software\") required for the use of Service are stated in this agreement in Section 3 below\n" +
                "        (\"Software Terms\"). \"Terms\" and \"Software Terms\" are collectively referred to as the \"WATER\n" +
                "        MANAGEMENT SYSTEM Terms\".</p>\n" +
                "    <ol>\n" +
                "        <li>\n" +
                "            <b>REGISTRATION</b><br/><br/>\n" +
                "            <span>Please read these WATER MANAGEMENT SYSTEM Terms before registering for the Service.  By completing your registration and clicking on the \"I Accept\" button below, you will become a registered user of the Service and Software (a \"Subscriber\").  You also agree to conduct business electronically and to be bound by the WATER MANAGEMENT SYSTEM Terms. </span><b>IF\n" +
                "            YOU DO NOT AGREE TO THE WATER MANAGEMENT SYSTEM TERMS OR TO DO BUSINESS ELECTRONICALLY,\n" +
                "            PLEASE DO NOT REGISTER FOR THE SERVICE. </b><span>The WATER MANAGEMENT SYSTEM Terms are subject to change by the Company at any time; however, the most current version of the WATER MANAGEMENT SYSTEM Terms will be available to you by clicking on the link identified on the Website.  You are encouraged to regularly review the WATER MANAGEMENT SYSTEM Terms to ensure that you are aware of any changes.  By continuing to use the Service after changes in the WATER MANAGEMENT SYSTEM Terms have been posted on the Website, you agree to be bound by the most current version of the WATER MANAGEMENT SYSTEM Terms.</span><br/><br/>\n" +
                "            <span>In the event of any conflict between these WATER MANAGEMENT SYSTEM Terms and the terms of any other offer for the Service, these WATER MANAGEMENT SYSTEM Terms will govern.</span><br/><br/>\n" +
                "            <span>Please print and retain a copy of the WATER MANAGEMENT SYSTEM Terms for your records. For information regarding how information is gathered and used at http://www.allegionWATER MANAGEMENT SYSTEM.com (the \"Website\"), please read our Privacy Policy at http://www.schlage.com/en/home/privacy.html. </span><br/><br/>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>CHANGES/UPGRADES TO THE SERVICES</b><br/><br/>\n" +
                "            <span>The Company has the right, in its sole discretion, to modify or change the Services and/or Software and any related Fees (as defined below), and will notify you of such changes via the Website, or if there are material changes to the Services and/or Software, the Company will notify you via the e-mail provided by you during registration.  Your continued use after such modification(s) or change(s) are made constitutes your acceptance of such Service, Software, and/or Fees.  However, if at any time you are not satisfied with the Service, Software, and/or Fees, you will always have the right to terminate the Service subject to the terms provided in Section 9 below.</span><br/><br/>\n" +
                "            <span>You will receive all software updates to your existing Service at no charge by the Company. If you choose to add additional services or features to your existing Service, you may be required to purchase such additional services or features from the Company in order to activate and use such services or features.</span><br/><br/>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>USE OF SERVICE</b><br/><br/>\n" +
                "            <b>Eligibility</b><span> – You must be 18 years old, or the age of majority, as determined by your local residency, to become a registered user and assume the obligations set forth in these WATER MANAGEMENT SYSTEM Terms.</span><br/><br/>\n" +
                "            <b>Service Area</b><span> – Your service area will be dependent on your working Internet access.</span><br/><br/>\n" +
                "            <b>System Requirements</b><span> – The Company does not manufacture, sell, or install the third party system components required to utilize this Service.  You may only access and use the Service with components capable of receiving the Service as identified below (\"Third Party Components).  You must purchase all Third Party Components, including any applicable installation, service, and parts, from a participating seller or manufacturer.  Third Party Components are not subject to the WATER MANAGEMENT SYSTEM Terms, warranty, return policy.  The Company is not responsible for any loss or damage to your personal, commercial, or real property, including without limitation, your business, commercial or personal belongings or property or that of your customers, resulting from the installation or use of the Service or use of Third Party Components with the Service.  The Company is not responsible for the advertising, practices, promises, statements, services, or other items made by the manufacturers or sellers of the Third Party Components.  If you have any questions regarding your Third Party Components, contact the applicable manufacturer or seller of that Third Party Components.</span><br/><br/>\n" +
                "            <b>THIRD PARTY COMPONENTS:</b><br/><br/>\n" +
                "            <span>Overall system requirements:</span><br/><br/>\n" +
                "            <ul>\n" +
                "                <li>Working Mobile Device (full functionality available)</li>\n" +
                "                <li>Computer (PC only) with Internet Access (limited functionality available)</li>\n" +
                "                <li>Active Wireless Internet Connection (https)</li>\n" +
                "                <li>Local area network protected by a Firewall (port 443 shall not be restricted)\n" +
                "                </li>\n" +
                "                <li>A valid email address</li>\n" +
                "                <li>A valid physical address</li>\n" +
                "            </ul>\n" +
                "            <br/>\n" +
                "            <span>Supported internet browsers for online access to the Service can be found at http://www.allegionWATER MANAGEMENT SYSTEM.com.</span><br/><br/>\n" +
                "            <b>Personal use of the service</b><span> – You may allow multiple individuals to use this Service through your WATER MANAGEMENT SYSTEM Software account subject to the WATER MANAGEMENT SYSTEM Terms.  However, you are responsible for ensuring that such users comply with the WATER MANAGEMENT SYSTEM Terms.  You may not assign your obligations under these WATER MANAGEMENT SYSTEM Terms to any other party.  Only the person designated as the account owner will have the right to cancel or change Services.</span><br/><br/>\n" +
                "            <b>Safety and Access Control</b><span> – It is your responsibility to exercise discretion and observe all safety measures that you deem necessary or as may be required by law to protect your business and any personal and real property and to prevent unauthorized access, misuse of passwords, or misuse of any other information.  You may only access and use the Website as authorized by the WATER MANAGEMENT SYSTEM Terms and any other materials the Company provides to you. The Company is not liable to you for any unauthorized access or misuse of the Service and Website.  You may not use the Website in any manner that could damage, disable, overburden, or impair the Website or interfere with any other party's use and enjoyment of the Website.  You may not attempt to gain unauthorized access to the Website, computer systems or networks connected to the Website, through hacking, password mining, or any other means.  You agree that you will not WATER MANAGEMENT SYSTEM in any activities with respect to the Website that are contrary to any applicable laws, rules, and regulations.</span><br/><br/>\n" +
                "            <b>Service Interruptions</b><span> – Since the Service is web based, it may be interrupted or negatively affected by items outside of the control of the Company.  The Company is not liable to you for interruptions of or problems with the Service caused by acts of any governmental body, war, insurrection, sabotage, armed conflict, embargo, fire, flood, strike or other labor disturbance, interruption of or delay in transportation, unavailability of or interruption or delay in telecommunications or third party services obtained by you or the Company, virus attacks or hackers, failure of third party software (including, without limitation, e-business software, payment gateways, chat, statistics or free scripts) or inability to obtain raw materials, supplies, or power used in or equipment needed for provision of the Services; failure of access circuits to the Company's computer network, unless such failure is caused solely by the Company; DNS (\"Domain Name Server\") issues outside the direct control of the Company; Issues with FTP, POP3, SMTP, or any items relating to your access to the Website or the Services; your acts or omissions (or acts or omissions of others WATER MANAGEMENT SYSTEMd or authorized by you, including, without limitation, custom scripting or coding (e.g., COI, Perl, HTML, ASP, etc.), any negligence, willful misconduct, or use of Website or Services in breach of this Agreement; e-mail or WebMail delivery and transmission; DNS propagation; or outages elsewhere on the Internet that hinder access to the Website or the Services.  Your Service is dependent on you ensuring that your Third Party Components are active and fully functioning.  The Company is not liable due to any failure of your Third Party Components.</span><br/><br/>\n" +
                "            <b>Restrictions on Use</b><span> – You agree that you will not copy, translate, rent, lease, or sublicense the Software; and/or cause or permit reverse compilation, reverse engineering, or reverse assembly of all or any portion of the Software.</span><br/><br/>\n" +
                "            <b>Software Requirements</b><span> – The WATER MANAGEMENT SYSTEM SOFTWARE (\"Licensed Software\") is required for the use of the Service and certain Company components (e.g., Schlage NDE products).  The following software terms and conditions shall apply:</span><br/><br/>\n" +
                "            <div style=\"padding-left: 20px;\">\n" +
                "                <span>READ THE FOLLOWING TERMS AND CONDITIONS OF THIS SOFTWARE LICENSE CAREFULLY BEFORE PROCEEDING.  BY PROCEEDING, YOU ARE ACCEPTING AND AGREEING TO THE FOLLOWING SOFTWARE LICENSE TERMS AND CONDITIONS.  IF YOU ARE NOT WILLING TO BE BOUND BY THE FOLLOWING SOFTWARE LICENSE TERMS AND CONDITIONS, YOU SHOULD CHOOSE \"I DO NOT ASSENT\" AND PROMPTLY EXIT THE WATER MANAGEMENT SYSTEM SOFTWARE APPLICATION. THIS LICENSE AGREEMENT REPRESENTS THE ENTIRE AGREEMENT CONCERNING THE WATER MANAGEMENT SYSTEM SOFTWARE (\"SOFTWARE\") BETWEEN YOU AND SCHLAGE LOCK COMPANY, LLC (\"COMPANY\"), AND IT SUPERSEDES ANY PRIOR PROPOSAL, REPRESENTATION, OR UNDERSTANDING BETWEEN THE PARTIES.</span><br/><br/>\n" +
                "                <ol>\n" +
                "                    <li>\n" +
                "                        <b>LICENSE GRANT AND USE</b><br/><br/>\n" +
                "                        <ol type=\"A\">\n" +
                "                            <li>Company grants to You a nonexclusive, non transferable license to\n" +
                "                                access the Software by downloading a web-based machine-readable\n" +
                "                                version of the Software, as may be updated from time to time without\n" +
                "                                notice by Licensor at Licensor's sole discretion (\"Licensed\n" +
                "                                Software\"), as well as any user manuals and technical materials\n" +
                "                                viewable and printable through Licensor's website (the\n" +
                "                                \"Documentation\"). The Licensed Software and Documentation are\n" +
                "                                collectively called the \"System.\"<br/><br/></li>\n" +
                "                            <li>You acknowledge that You have no ownership, rights, title or other\n" +
                "                                interest in the Software apart from that granted hereunder. All\n" +
                "                                rights, title, and interest including, but not limited to,\n" +
                "                                intellectual property interests, in and to the System are the\n" +
                "                                exclusive property of Licensor, and this Agreement shall not be\n" +
                "                                deemed a transfer of title or ownership in any respect.<br/><br/>\n" +
                "                            </li>\n" +
                "                            <li>You acknowledge that the license granted hereunder is terminable at\n" +
                "                                will by Company in its sole and absolute discretion. Termination of\n" +
                "                                the Agreement revokes Your license and ends Your rights. In case of\n" +
                "                                such termination, You will immediately cease use of the System. The\n" +
                "                                terms that by their sense and context are intended to survive\n" +
                "                                performance by either or both parties shall so survive the\n" +
                "                                performance and termination of the Agreement, including without\n" +
                "                                limitation those terms relating to warranty limitations, limitation\n" +
                "                                of liability, remedies or damages, or Company's proprietary\n" +
                "                                rights.<br/><br/></li>\n" +
                "                            <li>You acknowledge that the Licensed Software may include software\n" +
                "                                provided by third parties (\"Third Party Software\") and the licensor\n" +
                "                                of any Third Party Software embedded in the Licensed Software has a\n" +
                "                                proprietary interest in such software.<br/><br/></li>\n" +
                "                            <li>You may view and download a single copy of the Documentation solely\n" +
                "                                for Your personal, non-commercial use. You will not otherwise, in\n" +
                "                                whole or in part, sublicense, copy, rent, loan, transfer, modify,\n" +
                "                                enhance, prepare derivatives of, decompile, or reverse engineer any\n" +
                "                                portion of the System.<br/><br/></li>\n" +
                "                            <li>If any modifications, enhancements, improvements or alterations to\n" +
                "                                the Software are or have been made by Company, You or any non-party,\n" +
                "                                either singly or in combination, all such modifications,\n" +
                "                                enhancements, improvements or alterations shall belong exclusively\n" +
                "                                to Company. You agree to assign to Company any ownership or other\n" +
                "                                right, title and interest in or to any such improvements,\n" +
                "                                enhancements, modifications or alterations and to execute any\n" +
                "                                documents to facilitate said assignment that are requested of it by\n" +
                "                                Company.<br/><br/></li>\n" +
                "                            <li>Your rights hereunder may not be assigned, sold, transferred,\n" +
                "                                pledged or encumbered in any way. You may not sell, sublicense or\n" +
                "                                rent Software to any third-party. Company may assign this Agreement.<br/><br/>\n" +
                "                            </li>\n" +
                "                        </ol>\n" +
                "                    </li>\n" +
                "                    <li><b>MAINTENANCE.</b> Company shall have no obligation to support or maintain\n" +
                "                        Software.<br/><br/></li>\n" +
                "                    <li><b>CONSULTING AND TRAINING.</b> Consulting and training services are not\n" +
                "                        provided under this Agreement.<br/><br/></li>\n" +
                "                    <li><b>PROPRIETARY RIGHTS.</b> You acknowledge that System is a proprietary\n" +
                "                        asset of Company.<br/><br/></li>\n" +
                "                    <li><b>WARRANTIES.</b> COMPANY MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY\n" +
                "                        KIND WHATSOEVER AS TO THE PERFORMANCE OR FUNCTIONALITY OF THE SOFTWARE. THE\n" +
                "                        LICENSE OF SAID SOFTWARE HEREUNDER IS STRICTLY ON AN \"AS-IS\" BASIS. ANY\n" +
                "                        IMPLIED WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE,\n" +
                "                        TITLE, AND NON-INFRINGEMENT ARE EXPRESSLY DISCLAIMED WHETHER SUCH WARRANTIES\n" +
                "                        ARE EXPRESS, IMPLIED, OR STATUTORY.<br/><br/></li>\n" +
                "                    <li><b>LIMITATION OF LIABILITY.</b> YOU WAIVE AND RELEASE ANY CAUSES OF ACTION,\n" +
                "                        BOTH AT LAW OR IN EQUITY, AND/OR ANY REMEDIES YOU MIGHT CURRENTLY HAVE OR\n" +
                "                        HEREAFTER ACQUIRE AGAINST COMPANY, OR ITS RELATED BUSINESSES, SUPPLIERS,\n" +
                "                        AGENTS, OR REPRESENTATIVES ARISING EITHER HEREUNDER OR FROM YOUR PRIOR USE\n" +
                "                        OF THE SOFTWARE. IN NO EVENT, SHALL EITHER PARTY HAVE ANY LIABILITY TO THE\n" +
                "                        OTHER FOR INDIRECT, INCIDENTAL OR CONSEQUENTIAL DAMAGES, INCLUDING, BUT NOT\n" +
                "                        LIMITED TO, LOST PROFITS, OR FOR SPECIAL, EXEMPLARY OR PUNITIVE DAMAGES, AND\n" +
                "                        EACH PARTY COVENANTS NOT TO SEEK SUCH DAMAGES WITH RESPECT TO ANY CLAIMS\n" +
                "                        ARISING OUT OF OR RELATED TO THIS AGREEMENT.<br/><br/></li>\n" +
                "                    <li><b>EXPORT CONTROL.</b> The United States controls the export of products and\n" +
                "                        information. You agree to comply with such restrictions and not to export or\n" +
                "                        re-export the System or any portion thereof to countries or persons\n" +
                "                        prohibited under the export control laws. By downloading the System, you are\n" +
                "                        agreeing that you are not in a country where such export is prohibited and\n" +
                "                        that you are not on the U.S. Commerce Department's Table of Denial Orders or\n" +
                "                        the U.S. Treasury Department's list of Specially Designated Nationals. You\n" +
                "                        are responsible for compliance with the laws of your local jurisdiction\n" +
                "                        regarding the import, export, or re-export of the System.<br/><br/></li>\n" +
                "                    <li><b>USER INFORMATION.</b> The Company may use the information it obtains\n" +
                "                        relating to You, including, but not limited to, Your Internet Protocol\n" +
                "                        (\"IP\") address, name, mailing address, email address, cellular phone\n" +
                "                        information, and use of the Web Site, for its internal business and\n" +
                "                        marketing purposes and may disclose the information to third parties for\n" +
                "                        such purposes, strictly subject to the privacy specifications set forth in\n" +
                "                        the Company's Privacy/Security Policy available on the Company's\n" +
                "                        Website.<br/><br/></li>\n" +
                "                    <li><b>GOVERNING LAW</b><br/><br/><b>The United Nations Convention on the\n" +
                "                        International Sale of Goods is explicitly excluded from this\n" +
                "                        Agreement.</b><br/><br/><span>This Agreement and any action related thereto or related to the Software shall be governed, controlled, interpreted, and defined by and under the laws in effect in the State of Indiana, United States of America without regard to conflicts of law principles. Venue for any action, claim or proceeding pertaining to this Agreement shall be Indiana and you hereby irrevocably and unconditionally consent and submit to the exclusive jurisdiction of such courts for the purpose of such action.</span><br/><br/>\n" +
                "                    </li>\n" +
                "                    <li><b>ENTIRE AGREEMENT.</b> This represents the entire agreement and\n" +
                "                        understanding of the parties with respect to the subject matter of this\n" +
                "                        Agreement and supercedes all prior agreements and understandings between the\n" +
                "                        parties, whether oral or written, with respect to this subject matter.\n" +
                "                        Notwithstanding the foregoing, the Terms and Conditions of Company's web\n" +
                "                        site are incorporated herein by reference and are made part of this\n" +
                "                        Agreement. You acknowledge that such Terms and Conditions may be changed at\n" +
                "                        any time without notice by Company, and that such changes to the Terms and\n" +
                "                        Conditions shall be binding upon You.<br/><br/></li>\n" +
                "                </ol>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>FEES</b><br/><br/>\n" +
                "            <span>Any fees related to the Service (the \"Fees\") are due in advance of the Service being provided and will include all applicable sales tax and will be billed to you and transacted by the Company or its designated third party provider.</span><br/><br/>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>WARRANTIES</b><br/><br/>\n" +
                "            <span>THE COMPANY MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND WHATSOEVER AS TO THE AVAILABILITY, PERFORMANCE OR FUNCTIONALITY OF THE SERVICE, THE WEBSITE, OR SOFTWARE AND ALL ASSOCIATED SERVICES AND INFORMATION (COLLECTIVELY \"WATER MANAGEMENT SYSTEM SERVICES\") OR FOR ANY THIRD PARTY COMPONENTS PURCHASED BY YOU OR THIRD PARTY SERVICE PURCHASED BY COMPANY.  THE COMPANY MAKES NO WARRANTY THAT THE SOFTWARE WILL MEET YOUR REQUIREMENTS OR OPERATE IN THE COMBINATIONS WHICH MAY BE SLECTED FOR USE BY YOU OR YOUR CUTOMERS, OR THAT THE OPERATION OF THE SOFTWARE WILL BE INTERUPPTED OR ERROR FREE.  THE WATER MANAGEMENT SYSTEM SERVICES ARE BEING PROVIDED TO YOU ON \"AS-IS\" AND \"AS AVAILABLE\" BASIS.  YOUR USE OF THE WATER MANAGEMENT SYSTEM SERVICES IS AT YOUR SOLE RISK.  ANY IMPLIED WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE, TITLE AND NON-INFRINGEMENT ARE EXPRESSLY DISCLAIMED WHETHER SUCH WARRANTIES ARE EXPRESS, IMPLIED, OR STATUTORY.</span><br/><br/>\n" +
                "            <span>THE THIRD PARTY LINKS, RESOURCES, AND CONTENT AVAILABLE WITH THE WATER MANAGEMENT SYSTEM SERVICES ARE NOT CONTROLLED BY THE COMPANY, AND THE COMPANY DOES NOT MAKE ANY WARRANTIES, EXPRESS OR IMPLIED, REGARDING SUCH THIRD PARTY LINKS, RESOURCES, AND CONTENT INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE, TITLE AND NON-INFRINGEMENT.  THE COMPANY WILL NOT BE LIABLE FOR YOUR ACCESS TO, USE OF OR DOWNLOADING OF CONTENT AVAILABLE ON OR THROUGH, THE SERVICE OR WEBSITE.</span><br/><br/>\n" +
                "            <span>SOME JURISDICTIONS MAY NOT ALLOW THE EXCLUSION OF CERTAIN IMPLIED WARRANTIES OR THE LIMITATION OF CERTAIN DAMAGES, SO SOME OF THE ABOVE DISLCAIMERS, WAIVERS, AND LIMITATIONS OF LIABILITY MAY NOT APPLY TO YOU.</span><br/><br/>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>LIABILITY</b><br/><br/>\n" +
                "            <span>THE COMPANY DOES NOT AUTHORIZE ANY PERSON TO CREATE FOR IT ANY OBLIGATION OR LIABILTY IN CONNECTION WITH THE WATER MANAGEMENT SYSTEM SERVICES.  TO THE MAXIMUM EXTENT PERMITTED BY APPLICABLE LAW, IN NO EVENT WILL THE COMPANY, ITS SUPPLIERS, THE LICENSOR OF ANY THIRD PARTY SOFTWARE EMBEDDED IN THE SYTEM, OR OTHER LICENSORS BE LIABLE FOR ANY SPECIAL, INCIDENTAL, INDIRECT, OR CONSEQUENTIAL DAMAGES WHATSOEVER, INCLUDING, BUT NOT LIMITED TO, DAMAGES FOR: LOSS OF PROFITS, LOSS OF CONFIDENTIAL OR OTHER INFORMATION, BUSINESS INTERRUPTION, PERSONAL INJURY, PERSONAL OR REAL PROPERTY DAMAGE, LOSS OF PRIVACY, FAILURE TO MEET ANY DUTY (INCLUDING OF GOOD FAITH OR OF REASONABLE CARE, OR NEGLIGENCE) AND ANY OTHER PECUNIARY OR OTHER LOSS WHATSOEVER, EVEN IF THE COMPANY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES, ARISING OUT OF OR IN ANY WAY RELATED TO (a) THE USE OF OR INABILITY TO USE THE WATER MANAGEMENT SYSTEM SERVICES; (b) THE COST OF PROCUREMENT OF SUBSTITUTE GOODS AND SERVICES; OR (c) ANY OTHER MATTER RELATING TO THE WATER MANAGEMENT SYSTEM SERVICES. EXCEPT AS OTHERWISE PROVIDED IN THESE WATER MANAGEMENT SYSTEM TERMS, IF YOU ARE DISSATISFIED WITH ANY PORTION OF THE WATER MANAGEMENT SYSTEM SERVICES, YOUR SOLE AND EXCLUSIVE REMEDY IS TO CANCEL AND DISCONTINUE USING THE WATER MANAGEMENT SYSTEM SERVICES AND TO RECEIVE A REFUND FOR SERVICES NOT RENDERED.  IN NO INSTANCE WILL THE COMPANY'S LIABILITY TO YOU EXCEED THE FEES PAID BY YOU IN THE TWELVE (12) MONTH PERIOD PRIOR TO THE CLAIM AT ISSUE AND YOU AGREE THAT THIS LIMITATION REPRESENTS A REASONABLE ALLOCATION OF RISK.  THE FOREGOING EXCLUSIONS AND LIMITATIONS WILL APPLY REGARDLESS OF ANY ALLEGATION OR FINDING THAT A REMEDY FAILED OF ITS ESSENTIAL PURPOSE, REGARDLESS OF THE FORM OF ACTION OR THEORY OF LIABILITY (INCLUDING, WITHOUT LIMITATION, NEGLIGENCE) AND EVEN IF THE COMPANY OR OTHERS WERE ADVISED OR AWARE OF THE POSSIBILITY OF LIKELIHOOD OF SUCH DAMAGES OR LIABILITY.</span><br/><br/>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>INDEMNIFICATION</b><br/><br/>\n" +
                "            <span>BY REGISTERING FOR THE SERVICE, YOU AGREE TO INDEMNIFY, DEFEND AND HOLD SCHLAGE LOCK COMPANY, LLC, ITS PARENT COMPANY, SUBSIDIARIES, AFFILIATES, SUPPLIERS, AND LICENSORS, AND THE RESPECTIVE OFFICERS, DIRECTORS, EMPLOYEES, AGENTS, AND ASSIGNS HARMLESS FROM AND AGAINST ANY AND ALL THIRD PARTY CLAIMS, DEMANDS, PROCEEDINGS, SUITS AND ACTIONS, INCLUDING ANY RELATED LIABILITIES, OBLIGATIONS, LOSSES, DAMAGES, PENALTIES, FINES, JUDGMENTS, SETTLEMENTS, EXPENSES (INCLUDING ATTORNEYS' AND ACCOUNTANTS' FEES AND DISBURSEMENTS) AND COSTS INCURRED BY, BORNE BY OR ASSERTED AGAINST THE COMPANY TO THE EXTENT SUCH CLAIMS IN ANY WAY RELATE TO, ARISE OUT OF, OR RESULT FROM YOUR USE OF THE WATER MANAGEMENT SYSTEM SERVICES.</span><br/><br/>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>AGREEMENT TO MANDATORY ARBITRATION</b><br/><br/>\n" +
                "            <span>Instead of suing in court, you and the Company agree to resolve all disputes and claims between us only by binding and bilateral arbitration. There is no judge or jury in arbitration, and court review of an arbitration award is limited. YOU AGREE THAT, BY ENTERING INTO THIS AGREEMENT, YOU AND THE COMPANY ARE EACH WAIVING THE RIGHT TO A TRIAL BY JURY AND THE RIGHT TO PARTICIPATE IN A CLASS OR REPRESENTATIVE ACTION.  However, just as a court would, the arbitrator can award damages and relief, including any attorneys' fees if authorized by law.  The arbitrator's decision and award is final and binding, with some exceptions under the Federal Arbitration Act, 9 U.S.C. 1, et seq., and judgment on the award may be entered in any court with jurisdiction.</span><br/><br/>\n" +
                "            <span>References to the \"Company,\" \"you\" and \"us,\" for purposes of this agreement to arbitrate include our respective subsidiaries, affiliates, agents, employees, predecessors in interest, heirs, guardians, successors and assigns, and all authorized or unauthorized users or beneficiaries of the Company's services</span><br/><br/>\n" +
                "            <span>This agreement to arbitrate is intended to be broadly interpreted.  It includes, but is not limited to (i) disputes and claims arising out of or relating to any aspect of the relationship between us, whether based in contract, tort, statute, fraud, misrepresentation or any other legal theory; (ii) claims that arose before this or any prior agreement (including, but not limited to, claims relating to advertising); (iii) claims that may arise after the termination of your relationship with the Company; and (iv) claims that are currently the subject of purported class action litigation in which you are not a member of a certified class.</span><br/><br/>\n" +
                "            <span>This arbitration agreement does not preclude you from bringing issues to the attention of federal, state, or local agencies. Such agencies can, if the law allows, seek relief against us on your behalf. In addition, and notwithstanding the other provisions of this arbitration agreement, either party may bring an individual action in small claims court.</span><br/><br/>\n" +
                "            <span>The Federal Arbitration Act, 9 U.S.C. 1, et seq. (the \"FAA\") governs the interpretation and enforcement of this agreement to arbitrate. The FAA's provisions, not state law, govern all questions of whether a dispute is subject to arbitration.</span><br/><br/>\n" +
                "            <span>Unless otherwise agreed to by you and the Company in writing, the arbitration will be governed and conducted by JAMS before a single arbitrator who is licensed to practice law. The JAMS rules, including the selection of an arbitrator, filing, administration, discovery and arbitrator fees will be conducted under JAMS Comprehensive Arbitration Rules & Procedures, except as modified by this agreement or otherwise agreed to by you and the Company in writing. The JAMS rules are available on its website at www.jamsadr.com. To the extent that this agreement to arbitrate conflicts with JAMS's Consumer Minimum Standards, the JAMS's Consumer Minimum Standards in that regard shall control. NOTHING IN THIS PARAGRAPH SHALL REQUIRE OR ALLOW YOU OR THE COMPANY TO ARBITRATE ON A CLASSWIDE OR CONSOLIDATED BASIS.</span><br/><br/>\n" +
                "            <span>THIS AGREEMENT DOES NOT ALLOW CLASS ARBITRATIONS EVEN IF JAMS PROCEDURES OR RULES WOULD. RATHER, YOU AND THE COMPANY ARE ONLY ENTITLED TO PURSUE ARBITRATION ON AN INDIVIDAL BASIS, AND UNLESS YOU AND THE COMPANY AGREE OTHERWISE IN WRITING, THE ARBITRATOR MAY NOT CONSOLIDATE MORE THAN ONE INDIVIDUAL PARTY'S CLAIMS WITH ANY OTHER PARTY'S CLAIMS, AND MAY NOT PRESIDE OVER ANY FORM OF A REPRESENTATIVE OR COLLECTIVE PROCEEDING.</span><br/><br/>\n" +
                "            <span>You and the Company are each responsible for their respective costs relating to counsel, experts, and witnesses, and any other costs relating to the arbitration. The Company, however, will pay for the arbitration administrative or filing fees, including the arbitrator and/or other JAMS case management fees, for any dispute of \$75,000 U.S. Dollars or less, unless the claim is determined by the arbitrator to be frivolous. Otherwise, the JAMS Comprehensive Arbitration Rules & Procedures and the JAMS Policy on Consumer Arbitrations Pursuant to Pre-Dispute Clauses, Minimum Standards of Procedural Fairness regarding costs and payment apply.</span><br/><br/>\n" +
                "            <span>Unless you and the Company agree otherwise in writing, the arbitration will take place in the county or Province of your billing address.</span><br/><br/>\n" +
                "            <span>An arbitration award and any judgment confirming it apply only to that specific case; it cannot be used in any other case except to enforce the award itself.</span><br/><br/>\n" +
                "            <span>IF FOR SOME REASON THE PROHIBITION ON CLASS AND/OR REPRESENTATIVE ARBITRATIONS SET FORTH ABOVE CANNOT BE ENFORCED, THEN THE AGREEMENT TO ARBITRATE WILL NOT APPLY.</span><br/><br/>\n" +
                "            <span>If for any reason a claim proceeds in court rather than through arbitration, you and the Company agree that there will not be a jury trial. You and the Company unconditionally waive any right to trial by jury in any action, proceeding or counterclaim arising out of or relating to this Agreement in any way. In the event of litigation, this paragraph may be filed to show a written consent to a trial by the court.</span><br/><br/>\n" +
                "            <span>If you or the Company fail to comply with this arbitration provision, the breaching party shall be liable for the costs and attorneys' fees incurred by the other party in enforcing compliance with the arbitration agreement.</span><br/><br/>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>TERM AND CANCELLATION</b><br/><br/>\n" +
                "            <span>Your Service will commence upon your acceptance of these WATER MANAGEMENT SYSTEM Terms and will continue until cancellation by either you or the Company as provided herein.</span><br/><br/>\n" +
                "            <span>You will have a right, at any time, to cancel the Service upon notice to the Company's customer service.  If Services are cancelled by you, no refunds of any monies paid to Company will be issued.</span><br/><br/>\n" +
                "            <span>The Company reserves the right to suspend or cancel the Services at any time if you fail to pay amounts owing to the Company when due, violate or breach any of the WATER MANAGEMENT SYSTEM Terms, or for any other reason in its sole discretion.  If your Service is suspended or cancelled, you will still be responsible for payment of all outstanding balances accrued through the cancellation date, including any fees described herein.</span><br/><br/>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <b>GENERAL</b><br/><br/>\n" +
                "            <b>Waiver.</b><span> Any waiver granted herein shall not be deemed effective unless in writing, executed by the party as to whom enforcement of the waiver is sought. A waiver by either party of any provision(s) hereof shall not be deemed a waiver as to any other provision hereof or of any subsequent breach by either party of the same or any other provision.</span><br/><br/>\n" +
                "            <b>Severability.</b><span> If any provision of these WATER MANAGEMENT SYSTEM Terms is prohibited or unenforceable by any applicable law, the provision shall be ineffective only to the extent and for the duration of the prohibition of unenforceability, without invalidating any of the remaining provisions.</span><br/><br/>\n" +
                "            <b>Survival.</b><span> The obligations of you under these WATER MANAGEMENT SYSTEM Terms that by their nature would continue beyond the termination of these WATER MANAGEMENT SYSTEM Terms including, but not limited to, those sections relating to Fees and Indemnification will survive any termination.</span><br/><br/>\n" +
                "            <b>Attorneys' Fees.</b><span> In the event the Company seeks legal action against you for collection of any Fees or to enforce its rights and your obligations under these WATER MANAGEMENT SYSTEM Terms, the Company is entitled to recover from you its reasonable costs and expenses including, but not limited to, reasonable attorneys' fees incurred as a result.</span><br/><br/>\n" +
                "            <b>Remedies.</b><span> The rights and remedies provided to the Company under these WATER MANAGEMENT SYSTEM Terms are in addition to any other remedies available at law or in equity.</span><br/><br/>\n" +
                "            <b>Governing Law and Venue.</b><br/><br/>\n" +
                "            <b>The United Nations Convention on the International Sale of Goods is explicitly\n" +
                "                excluded from this Agreement.</b><br/><br/>\n" +
                "            <span>These WATER MANAGEMENT SYSTEM Terms and any action related thereto or related to Services shall be governed, controlled, interpreted, and defined by and under the laws in effect in the State of Indiana, United States of America, without regard to conflicts of law principles. Venue for any action, claim or proceeding pertaining to this Agreement shall be Indiana and you hereby irrevocably and unconditionally consent and submit to the exclusive jurisdiction of such courts for the purpose of such action.</span><br/><br/>\n" +
                "            <span>Notwithstanding the foregoing and pursuant to Section 8 of this Agreement, the Federal Arbitration Act, 9 U.S.C. 1, et seq. (the \"FAA\") governs the interpretation and enforcement of this Agreement to arbitrate. The FAA's provisions, not state law, govern all questions of whether a dispute is subject to arbitration.</span><br/><br/>\n" +
                "            <b>Entire Agreement.</b><span> These WATER MANAGEMENT SYSTEM Terms represent the entire agreement and understanding of the parties with respect to the subject matter of these terms and conditions and supersedes all prior agreements and understandings between the parties, whether oral or written, with respect to this subject matter.</span><br/><br/>\n" +
                "            <span>If you have any questions regarding these WATER MANAGEMENT SYSTEM Terms or any terms referenced herein, please contact the Company in any manner as follows:</span><br/><br/>\n" +
                "            <span>Address: Schlage Lock Company, LLC, 11819 N. Pennsylvania Street, Carmel, Indiana 46032</span><br/>\n" +
                "            <span>Phone: 800.847.1864 (Option 3)</span><br/><br/>\n" +
                "            <span>BY USING THE SERVICES, I REPRESENT THAT I HAVE READ AND UNDERSTAND THESE ENTIRE WATER MANAGEMENT SYSTEM TERMS, AND I AGREE TO ALL THE TERMS AND CONDITIONS OF THE SERVICES AS STATED ABOVE.</span><br/><br/><br/>\n" +
                "        </li>\n" +
                "    </ol>\n" +
                "</font>\n" +
                "</body>\n" +
                "</html>"

        webView?.loadData(htmlFile, "text/html; charset=UTF-8", null)
        WebView.setWebContentsDebuggingEnabled(false)
    }

    fun acceptBtnClicked(view: View) {
        val intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
    }

    fun declineBtnClicked(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
